package top.kwrcee.sortcourse.manage.controller;

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
import top.kwrcee.sortcourse.manage.entities.Schedule;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.service.ScheduleService;
import top.kwrcee.sortcourse.manage.service.ValueSetService;

/**
 *  管理 API
 *
 * @author guangrui.liu@hand-china.com
 * @date 2019-03-16 14:11:23
 */
@Controller
@RequestMapping("/manage-schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ValueSetService valueSetService;

    /**
     * 查询时间表列表
     * @param model
     * @param pageRequest
     * @param schedule
     * @return
     */
    @PreAuthorize("hasAuthority('list-schedule')")
    @GetMapping("/schedules")
    public String search(Model model, @SortDefault(value = Schedule.FIELD_TIME_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest, Schedule schedule){
        pageRequest.setSize(10);
        Page<Schedule> pageInfo=scheduleService.pageScheduleList(pageRequest,schedule);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/schedule/schedule-list";
    }
    /**
     * 时间表添加
     * @param schedule
     * @return
     */
    @PreAuthorize("hasAuthority('add-schedule')")
    @PostMapping("/schedule")
    public String addSchedule(Schedule schedule){
        scheduleService.insert(schedule);
        return "redirect:/manage-schedule/schedules";
    }

    /**
     * 时间表删除
     * @param id
     * @return
     */
    @DeleteMapping("/schedule/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('delete-schedule')")
    public ResponseEntity<String> deleteSchedule(@PathVariable("id")Long id){
        System.out.println("has deleted");
        scheduleService.deleteByPrimaryKey(id);
        return ResponseEntity.ok("success");
    }
    /**
     * 来到修改页面，查出当前信息，然后回显
     * @param id
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('update-schedule')")
    @GetMapping("/schedule/{id}")
    public String toEditPage(@PathVariable("id") Long id,Model model){
        Schedule schedule = scheduleService.selectByPrimaryKey(id) ;
        model.addAttribute("schedule",schedule);
        return "admin/schedule/schedule-detail";
    }
    /**
     * 时间表更新
     * @param schedule
     * @return
     */
    @PreAuthorize("hasAuthority('update-schedule')")
    @PutMapping("/schedule")
    public String updateSchedule(Schedule schedule){
        System.out.println(schedule);
        Integer flag=scheduleService.updateByPrimaryKey(schedule);
        return "redirect:/manage-schedule/schedules";
    }
    /**
     * 去添加界面
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('add-schedule')")
    @GetMapping("/schedule")
    public String toAddPage(Model model){
        ValueSet valueSet =new ValueSet();
        return "admin/schedule/schedule-add";
    }

}