package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseServiceImpl;
import lombok.extern.java.Log;
import net.sf.jsqlparser.expression.TimeValue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.entities.Schedule;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.mapper.CourseMapper;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.service.ScheduleService;
import top.kwrcee.sortcourse.manage.service.ValueSetService;
import top.kwrcee.sortcourse.manage.utils.Constants;
import top.kwrcee.sortcourse.manage.utils.WeekUtils;
import top.kwrcee.sortcourse.manage.vo.CourseVO;
import top.kwrcee.sortcourse.manage.vo.Week;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    CourseService courseService;
    @Autowired
    ValueSetService valueSetService;
    @Autowired
    WeekUtils weekUtils;

    @Override
    public Page<CourseVO> pageCourseList(PageRequest pageRequest, Course course) {
        return PageHelper.doPageAndSort(pageRequest,()->courseMapper.selectByCourseDistinct(course));
    }

    @Override
    public List<CourseVO> courseList(Course course) {
        return courseMapper.selectByCourse(course);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourse(Course course) {
        Course condition =new Course();
        condition.setCourseNum(course.getCourseNum());
        //先删除存入的课程数
        if(course.getCourseNum()==null){
            throw new RuntimeException("Course Num can't be null!");
        }
        courseMapper.delete(condition);
        //执行插入操作
        insertCourse(course);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertCourse(Course course) {
        //设置最大行号
        course.saveLineNum(courseMapper);
        //如果更新的时候数量是1或者空，直接插入后返回
        if(course.getCourseQuantity()==null|| Constants.DefaultLongNumber.ONE.equals(course.getCourseQuantity())){
            courseMapper.insertSelective(course);
            return;
        }
        for (int i=0;i<course.getCourseQuantity();i++){
            course.setCourseId(null);
            courseMapper.insertSelective(course);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CourseVO> sortCourse() {
        Course condition=new Course();
        condition.setSortStatusFlag(Constants.Flag.NO);
        List<CourseVO> list=courseMapper.selectByCourse(condition);
        List<CourseVO> sortedList=new ArrayList<>();
        //查询一周上课的天数和一天上课的天数
        Week globalWeek=weekUtils.getGlobalWeek();
        List<Week> weeks=new ArrayList<>();
        //从值集中获取
        for(int i = 0;i<globalWeek.getDay();i++){
            for(int j = 0;j<globalWeek.getTime();j++){
                Week week=new Week();
                week.setDay(i+1);
                week.setTime(j+1);
                weeks.add(week);
            }
        }
        weeks.forEach(week -> {
            //todo 在此可以完善指定日期不排课功能（某班，某老师，某教室）
            log.info("当前时间是第"+week.getDay()+"天,第"+week.getTime()+"节课");
            list.forEach(courseVO->{
                //如果没有冲突并且不包含在已排课的list中，则插入时间表
                if(courseVO.validateConflict(courseMapper,week)
                        &&!sortedList.contains(courseVO)){
                    log.info("\n>>排课id为："+courseVO.getCourseId());
                    scheduleService.insertSelective(new Schedule(week,courseVO));
                    sortedList.add(courseVO);
                    //课程的排课状态更新为 1
                    Course course=new Course();
                    BeanUtils.copyProperties(courseVO,course);
                    course.setSortStatusFlag(Constants.Flag.YES);
                    courseService.updateOptional(course,Course.FIELD_SORT_STATUS_FLAG);
                }
            });
        });
        return list;
    }

    @Override
    public String deleteList(List<Long> nums) {
        nums.forEach(num->{
            Course course =new Course();
            course.setCourseNum(num);
            courseMapper.delete(course);
        });
        return "success";
    }
}
