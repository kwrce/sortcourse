package top.kwrcee.sortcourse.manage.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseService;
import top.kwrcee.sortcourse.manage.entities.Schedule;

import java.util.List;

public interface ScheduleService extends BaseService<Schedule> {
    /**
     * 分页查询时间表
     * @param pageRequest
     * @param schedule
     * @return
     */
    Page<Schedule> pageScheduleList(PageRequest pageRequest, Schedule schedule);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    String deleteList(List<Long> ids);

    /**
     * 时间表插入
     * @param schedule
     */
    void insertSchedule(Schedule schedule);

    /**
     * 时间表更新
     * @param schedule
     */
    void updateSchedule(Schedule schedule);

    /**
     * 删除时间表
     * @param id
     */
    void deleteSchedule(Long id);
}
