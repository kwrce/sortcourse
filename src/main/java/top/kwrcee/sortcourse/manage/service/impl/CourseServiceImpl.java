package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.entities.Schedule;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.mapper.CourseMapper;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.service.ScheduleService;
import top.kwrcee.sortcourse.manage.utils.Constants;
import top.kwrcee.sortcourse.manage.utils.ValueSetHelper;
import top.kwrcee.sortcourse.manage.utils.WeekHelper;
import top.kwrcee.sortcourse.manage.vo.CourseVO;
import top.kwrcee.sortcourse.manage.vo.Week;

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
    WeekHelper weekHelper;
    @Autowired
    ValueSetHelper valueSetHelper;

    /**
     * 刷新课程排课标志
     */
    @Override
    public void resetCourseSortFlag(Long courseId, Integer flag) {
        Course course = selectByPrimaryKey(courseId);
        if (null == course) {
            return;
        }
        course.setSortStatusFlag(flag);
        updateOptional(course, Course.FIELD_SORT_STATUS_FLAG);
    }

    @Override
    public Page<CourseVO> pageCourseList(PageRequest pageRequest, Course course) {
        return PageHelper.doPageAndSort(pageRequest, () -> {
            List<CourseVO> list = courseMapper.selectByCourseDistinct(course);
            //计算排课状态
            list.forEach(co -> {
                co.calculateSortFlag(courseMapper);
            });
            return list;
        });
    }

    @Override
    public List<CourseVO> courseList(Course course) {
        return courseMapper.selectByCourse(course);
    }

    /**
     * 更新课程信息
     * @param course
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourse(Course course) {
        Course condition = new Course();
        condition.setCourseNum(course.getCourseNum());
        if (course.getCourseNum() == null) {
            throw new RuntimeException("Course Num can't be null!");
        }
        Schedule schedule = new Schedule();
        //根据num获取id
        List<Course> courseList = courseMapper.select(condition);
        courseList.forEach(co->{
            //删除当前课程信息的时间表信息
            schedule.setCourseId(co.getCourseId());
            scheduleService.delete(schedule);
        });
        //删除存入的课程数
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
        if (course.getCourseQuantity() == null || Constants.DefaultLongNumber.ONE.equals(course.getCourseQuantity())) {
            courseMapper.insertSelective(course);
            return;
        }
        for (int i = 0; i < course.getCourseQuantity(); i++) {
            course.setCourseId(null);
            courseMapper.insertSelective(course);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CourseVO> sortCourse() {
        Course condition = new Course();
        condition.setSortStatusFlag(Constants.Flag.NO);
        //查询为排课的信息（不去重）
        List<CourseVO> list = courseMapper.selectByCourse(condition);
        List<CourseVO> sortedList = new ArrayList<>();
        //查询一周上课的天数和一天上课的天数
        List<Week> weeks = weekHelper.getGlobalWeeks();
        weeks.forEach(week -> {
            //todo 在此可以完善指定日期不排课功能（某班，某老师，某教室）
            log.info("当前时间是第" + week.getDay() + "天,第" + week.getTime() + "节课");
            list.forEach(courseVO -> {
                //如果没有冲突并且不包含在已排课的list中，则插入时间表
                if (courseVO.validateConflict(courseMapper, week)
                        && !sortedList.contains(courseVO)) {
                    log.info("\n>>排课id为：" + courseVO.getCourseId());
                    scheduleService.insertSelective(new Schedule(week, courseVO));
                    sortedList.add(courseVO);
                    //课程的排课状态更新为 1
                    Course course = new Course();
                    BeanUtils.copyProperties(courseVO, course);
                    course.setSortStatusFlag(Constants.Flag.YES);
                    updateOptional(course, Course.FIELD_SORT_STATUS_FLAG);
                }
            });
        });
        return list;
    }

    @Override
    public void countCourse(Model model) {
        List<ValueSet> grades = valueSetHelper.getValueList(ValueSetHelper.GRADE);
        Assert.notEmpty(grades, "Grade is empty!");
        model.addAttribute("grades", grades);
        Week week = weekHelper.getGlobalWeek();
        model.addAttribute("weekDay", week);
        Course course = new Course();
        Integer nameFlag=1;
        grades.forEach(grade -> {
            List<Integer> dayCourses = new ArrayList<>();
            course.setGrade(grade.getId());
            for (int i = 1; i <= Integer.valueOf(week.getDay()); i++) {
                Week conditionWeek = new Week();
                conditionWeek.setDay(i);
                List<CourseVO> courseVOS = courseMapper.selectTimeTable(course, conditionWeek);
                if (courseVOS.isEmpty()) {
                    dayCourses.add(0);
                } else {
                    dayCourses.add(courseVOS.size());
                }
            }
            model.addAttribute("collage"+grade.getId(),dayCourses);
        });
    }

    /**
     * 删除课程信息
     * @param condition
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCourse(Course condition) {
        //先根据课程id删除时间表信息
        List<Course> courseList=courseMapper.select(condition);
        Schedule schedule=  new Schedule();
        courseList.forEach(co->{
            schedule.setCourseId(co.getCourseId());
            scheduleService.delete(schedule);
        });
        courseMapper.delete(condition);
    }

    /**
     * 批量删除
     * @param nums
     * @return
     */
    @Override
    public String deleteList(List<Long> nums) {
        nums.forEach(num -> {
            Course course = new Course();
            course.setCourseNum(num);
            deleteCourse(course);
        });
        return "success";
    }
}









