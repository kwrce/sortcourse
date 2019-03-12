package top.kwrcee.sortcourse.manage.mapper;


import io.choerodon.mybatis.common.BaseMapper;
import io.choerodon.mybatis.service.BaseService;
import org.apache.ibatis.annotations.Mapper;
import top.kwrcee.sortcourse.manage.entities.Room;

import java.util.List;

/**
 * Mapper
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */

public interface RoomMapper extends BaseMapper<Room> {
    /**
     * 分页模糊查询教室信息
     * @param room
     * @return
     */
    List<Room> selectByRoom(Room room);
}

