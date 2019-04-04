package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.entities.Schedule;
import top.kwrcee.sortcourse.manage.mapper.ScheduleMapper;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.service.ScheduleService;
import top.kwrcee.sortcourse.manage.utils.Constants;

import java.util.List;

@Service
public class ScheduleServiceImpl extends BaseServiceImpl<Schedule> implements ScheduleService {
    @Autowired
    ScheduleMapper scheduleMapper;
    @Autowired
    CourseService courseService;
    @Override
    public Page<Schedule> pageScheduleList(PageRequest pageRequest, Schedule schedule) {
        return PageHelper.doPageAndSort(pageRequest,()->scheduleMapper.selectBySchedule(schedule));
    }

    /**
     * 时间表信息批量删除
     * @param ids
     * @return
     */
    @Override
    public String deleteList(List<Long> ids) {
        ids.forEach(id->{
            Schedule schedule = scheduleMapper.selectByPrimaryKey(id);
            Course course=courseService.selectByPrimaryKey(schedule.getCourseId());
            if(course!=null){
                course.setSortStatusFlag(Constants.Flag.NO);
                courseService.updateOptional(course,Course.FIELD_SORT_STATUS_FLAG);
            }
            scheduleMapper.deleteByPrimaryKey(id);
        });
        return "success";
    }

    /**
     * 时间表插入
     * @param schedule
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSchedule(Schedule schedule) {
        //转换日期定位
        schedule.convertToWeek();
        Course course = courseService.selectByPrimaryKey(schedule.getCourseId());
        if(course!=null){
            course.setSortStatusFlag(Constants.Flag.YES);
            courseService.updateOptional(course,Course.FIELD_SORT_STATUS_FLAG);
        }
        scheduleMapper.insert(schedule);
    }

    /**
     * 时间表更新
     * @param schedule
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSchedule(Schedule schedule) {
        //转换日期定位
        schedule.convertToWeek();
        Schedule delSchedule=new Schedule();
        Course course = courseService.selectByPrimaryKey(schedule.getCourseId());
        Schedule oldDate=scheduleMapper.selectByPrimaryKey(schedule);
        //如果更改的不是当前的课程
        if(course!=null && course.getCourseId()!=oldDate.getCourseId()){
            delSchedule.setCourseId(course.getCourseId());
            courseService.resetCourseSortFlag(oldDate.getCourseId(),Constants.Flag.NO);
            scheduleMapper.delete(delSchedule);
        }
        scheduleMapper.updateByPrimaryKey(schedule);
    }

    /**
     * 删除时间表信息， 同时将课程表中的排课标识置为0
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSchedule(Long id) {
        //删除时间表的时候将数据库中课程的排课表示置为 0
        Schedule schedule = scheduleMapper.selectByPrimaryKey(id);
        courseService.resetCourseSortFlag(schedule.getCourseId(),Constants.Flag.NO);
        scheduleMapper.deleteByPrimaryKey(id);
    }
}
