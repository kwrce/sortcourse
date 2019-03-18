package top.kwrcee.sortcourse.manage.controller;

import java.util.Date;
import java.util.List;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.kwrcee.sortcourse.manage.entities.Room;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.service.RoomService;
import top.kwrcee.sortcourse.manage.service.ValueSetService;
import top.kwrcee.sortcourse.manage.utils.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 *  管理 API
 *
 * @author guangrui.liu@hand-china.com
 * @date 2019-01-29 14:11:23
 */
@Controller
@RequestMapping("/manage-room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private ValueSetService valueSetService;

    /**
     * 查询教室列表
     * @param model
     * @param pageRequest
     * @param room
     * @return
     */
    @PreAuthorize("hasAuthority('"+Constants.AuthorityPermission.ROOM_LIST+"')")
    @GetMapping("/rooms")
    public String search(Model model, @SortDefault(value = Room.FIELD_ROOM_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest, Room room){
        pageRequest.setSize(10);
        Page<Room> pageInfo=roomService.pageRoomList(pageRequest,room);
        model.addAttribute("pageInfo",pageInfo);
        //查询楼号的值集
        ValueSet valueSet =new ValueSet();
        valueSet.setName(Constants.ValueSet.BUILDING_NAME);
        model.addAttribute("buildings",valueSetService.select(valueSet));
        return "admin/room/room-list";
    }
    /**
     * 教室添加
     * @param room
     * @return
     */
    @PreAuthorize("hasAuthority('add-room')")
    @PostMapping("/room")
    public String addRoom(Room room){
        roomService.insert(room);
        return "redirect:/manage-room/rooms";
    }

    /**
     * 教室删除
     * @param id
     * @return
     */
    @DeleteMapping("/room/{id}")
    @ResponseBody
    //@PreAuthorize("hasAuthority('delete-room')")
    public ResponseEntity<String> deleteRoom(@PathVariable("id")Long id){
        System.out.println("has deleted");
        roomService.deleteByPrimaryKey(id);
        return ResponseEntity.ok("success");
    }
    /**
     * 教室批量删除
     * @param ids
     * @return list
     */
    @PostMapping("/rooms/delete")
    @ResponseBody
    public ResponseEntity<List<Long>> deleteRooms(List<Long> ids){
        roomService.deleteList(ids);
        return ResponseEntity.ok(ids);
    }
    /**
     * 来到修改页面，查出当前信息，然后回显
     * @param id
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('update-room')")
    @GetMapping("/room/{id}")
    public String toEditPage(@PathVariable("id") Long id,Model model){
        Room room = roomService.selectByPrimaryKey(id) ;
        model.addAttribute("room",room);
        //查询楼层的值集
        ValueSet valueSet =new ValueSet();
        valueSet.setName(Constants.ValueSet.BUILDING_NAME);
        model.addAttribute("buildings",valueSetService.select(valueSet));
        return "admin/room/room-detail";
    }
    /**
     * 教室更新
     * @param room
     * @return
     */
    @PreAuthorize("hasAuthority('update-room')")
    @PutMapping("/room")
    public String updateRoom(Room room){
        System.out.println(room);
        Integer flag=roomService.updateByPrimaryKey(room);
        return "redirect:/manage-room/rooms";
    }
    /**
     * 去添加界面
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('add-room')")
    @GetMapping("/room")
    public String toAddPage(Model model){
        ValueSet valueSet =new ValueSet();
        //查询楼层值集
        valueSet.setName(Constants.ValueSet.BUILDING_NAME);
        model.addAttribute("buildings",valueSetService.select(valueSet));
        return "admin/room/room-add";
    }

}
