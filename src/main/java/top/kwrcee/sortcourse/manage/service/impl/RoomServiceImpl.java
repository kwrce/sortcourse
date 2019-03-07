package top.kwrcee.sortcourse.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kwrcee.sortcourse.manage.entities.Room;
import top.kwrcee.sortcourse.manage.mapper.RoomMapper;
import top.kwrcee.sortcourse.manage.service.RoomService;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomMapper roomMapper;
    @Override
    public List<Room> selectRooms(){
        return roomMapper.getRooms();
    }

    @Override
    public Integer save(Room room) {
        return roomMapper.saveRoom(room);
    }

    @Override
    public Integer add(Room room) {
        return roomMapper.addRoom(room);
    }

    @Override
    public Room selectOneRoom(Long id) {
        return roomMapper.selectOneRoom(id);
    }

    @Override
    public Integer delete(Long id) {
        return roomMapper.delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Room> deleteRooms(List<Room> rooms) {
        rooms.forEach(room -> roomMapper.delete(room.getRoomId()));
        return rooms;
    }
}
