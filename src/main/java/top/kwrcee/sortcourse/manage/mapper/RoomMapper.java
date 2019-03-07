package top.kwrcee.sortcourse.manage.mapper;


import org.apache.ibatis.annotations.Mapper;
import top.kwrcee.sortcourse.manage.entities.Room;

import java.util.List;

/**
 * Mapper
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */
@Mapper
public interface RoomMapper {

    List<Room> getRooms();

    Integer saveRoom(Room room);

    Integer addRoom(Room room);

    Room selectOneRoom(Long id);

    Integer delete(Long id);
}

