package top.kwrcee.sortcourse.manage.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseService;
import top.kwrcee.sortcourse.manage.entities.Room;

import java.util.List;

public interface RoomService extends BaseService<Room> {

    Integer deleteList(List<Long> ids);

    Page<Room> pageRoomList(PageRequest pageRequest, Room room);
}
