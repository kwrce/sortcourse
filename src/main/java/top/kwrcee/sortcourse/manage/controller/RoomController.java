package top.kwrcee.sortcourse.manage.controller;

import java.security.PrivateKey;
import java.util.List;

//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private ValueSetService valueSetService;
    /**
     * 列表
     */
//    @GetMapping("/rooms")
//    public String list(Model model, HttpServletRequest request){
//        String pages = request.getParameter("page");
//        String pageSizes = request.getParameter("pageSize");
//        pages = pages == null || pages.trim().length() == 0 ? "0":pages;
//        pageSizes = pageSizes == null || pageSizes.trim().length() == 0 ? "10":pageSizes;
//        Integer page = Integer.parseInt(pages);
//        Integer pageSize = Integer.parseInt(pageSizes);
//        PageHelper.startPage(page+1,pageSize);//设置分页的起始码以及页面大小 List agentList=agentService.getAgentLists();
//        List<Room> rooms = roomService.selectAll();
//        PageInfo pageInfo = new PageInfo(rooms);//传入list就可以l
//        model.addAttribute("pageInfo",pageInfo);
//        return "admin/index/room-list";
//    }

    @GetMapping("/rooms")
    public String search(Model model, PageRequest pageRequest,Room room){
        pageRequest.setSize(10);
        Page<Room> pageInfo=roomService.pageRoomList(pageRequest,room);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/room/room-list";
    }
    /**
     * 教室添加
     * @param room
     * @return
     */
    @PostMapping("/room")
    public String addRoom(Room room){
        roomService.insert(room);
        return "redirect:/rooms";
    }

    /**
     * 教室删除
     * @param id
     * @return
     */
    @DeleteMapping("/room/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteRoom(@PathVariable("id")Long id){
        System.out.println("has deleted");
        roomService.deleteByPrimaryKey(id);
        return ResponseEntity.ok("success");
    }
    /**
     * 教室批量删除
     * @param rooms
     * @return list
     */
    @PostMapping("/rooms/delete")
    @ResponseBody
    public ResponseEntity<List<Room>> deleteRooms(List<Room> rooms){
        roomService.deleteList(rooms);
        return ResponseEntity.ok(rooms);
    }
    /**
     * 来到修改页面，查出当前信息，然后回显
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/room/{id}")
    public String toEditPage(@PathVariable("id") Long id,Model model){
        Room room = roomService.selectByPrimaryKey(id) ;
        model.addAttribute("room",room);
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
    @PutMapping("/room")
    public String updateRoom(Room room){
        System.out.println(room);
        roomService.updateByPrimaryKey(room);
        return "redirect:/rooms";
    }
    /**
     * 去添加界面
     * @param model
     * @return
     */
    @GetMapping("/room")
    public String toAddPage(Model model){
        return "room/add";
    }

}
