package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kwrcee.sortcourse.manage.entities.Schedule;
import top.kwrcee.sortcourse.manage.mapper.ScheduleMapper;
import top.kwrcee.sortcourse.manage.service.ScheduleService;

import java.util.List;

@Service
public class ScheduleServiceImpl extends BaseServiceImpl<Schedule> implements ScheduleService {
    @Autowired
    ScheduleMapper scheduleMapper;
    @Override
    public Page<Schedule> pageScheduleList(PageRequest pageRequest, Schedule schedule) {
        return PageHelper.doPageAndSort(pageRequest,()->scheduleMapper.selectBySchedule(schedule));
    }

    @Override
    public String deleteList(List<Long> ids) {
        ids.forEach(id->scheduleMapper.deleteByPrimaryKey(id));
        return "success";
    }
}
