package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kwrcee.sortcourse.manage.entities.Room;
import top.kwrcee.sortcourse.manage.mapper.RoomMapper;
import top.kwrcee.sortcourse.manage.service.RoomService;

import java.util.List;
@Service
public class RoomServiceImpl extends BaseServiceImpl<Room> implements RoomService {
    @Autowired
    RoomMapper roomMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteList(List<Room> rooms) {
        rooms.forEach(room -> roomMapper.deleteByPrimaryKey(room.getRoomId()));
        return 1;
    }

    @Override
    public Page<Room> pageRoomList(PageRequest pageRequest, Room room) {
        return PageHelper.doPageAndSort(pageRequest,()->roomMapper.select(room));
    }
}
