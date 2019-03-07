package top.kwrcee.sortcourse.manage.service;

import top.kwrcee.sortcourse.manage.entities.Room;

import java.util.List;

public interface RoomService {
    List<Room> selectRooms();

    /**
     * 更新教室信息
     * @param room
     * @return
     */
    Integer save(Room room);

    /**
     * 添加教室信息
     * @param room
     * @return
     */
    Integer add(Room room);

    /**
     * 通过ID查询教室
     * @param id
     * @return
     */
    Room selectOneRoom(Long id);

    /**
     * 通过id删除数据
     * @param id
     * @return
     */
    Integer delete(Long id);

    List<Room> deleteRooms(List<Room> rooms);
}
