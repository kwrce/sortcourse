package top.kwrcee.sortcourse.manage.mapper;


import io.choerodon.mybatis.common.BaseMapper;
import top.kwrcee.sortcourse.manage.entities.Schedule;
import top.kwrcee.sortcourse.manage.entities.Schedule;

import java.util.List;

/**
 * Mapper
 *
 * @author guangrui.liu@hand-china.com 2019-03-20 14:11:23
 */

public interface ScheduleMapper extends BaseMapper<Schedule> {
    /**
     * 查询时间表
     * @param schedule
     * @return
     */
    List<Schedule> selectBySchedule(Schedule schedule);
}

