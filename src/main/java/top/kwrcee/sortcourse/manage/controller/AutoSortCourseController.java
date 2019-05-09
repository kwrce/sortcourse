package top.kwrcee.sortcourse.manage.controller;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.kwrcee.sortcourse.manage.entities.ClassDto;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.entities.Schedule;
import top.kwrcee.sortcourse.manage.service.ClassDtoService;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.service.ScheduleService;
import top.kwrcee.sortcourse.manage.utils.ValueSetHelper;
import top.kwrcee.sortcourse.manage.utils.WeekHelper;
import top.kwrcee.sortcourse.manage.vo.CourseVO;
import top.kwrcee.sortcourse.manage.vo.Week;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/auto-sort")
@Log
public class AutoSortCourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    WeekHelper weekHelper;
    @Autowired
    ValueSetHelper valueSetHelper;
    @Autowired
    ClassDtoService classDtoService;
    @Autowired
    ScheduleService scheduleService;

    /**
     * 自动排课
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('list-course')")
    @PostMapping("/sort")
    public String sortCourse(Model model){
        List<CourseVO> list = courseService.sortCourse();
        model.addAttribute("list",list);
        return "redirect:/auto-sort/course-sorted";
    }
    /**
     * 查询班级列表
     * @param model
     * @param pageRequest
     * @param classDto
     * @return
     */
    @PreAuthorize("hasAuthority('list-course')")
    @GetMapping("/classDtos")
    public String search(Model model, @SortDefault(value = ClassDto.FIELD_CLASS_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest, ClassDto classDto){
        pageRequest.setSize(10);
        Page<ClassDto> pageInfo=classDtoService.pageClassDtoList(pageRequest,classDto);
        model.addAttribute("grades",valueSetHelper.getValueList(ValueSetHelper.GRADE));
        model.addAttribute("pageInfo",pageInfo);
        return "admin/class-sorted/class-sort-list";
    }
    /**
     * 来到班级排课页面，查出当前信息，然后回显
     * @param id
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('list-course')")
    @GetMapping("/classDto/{id}")
    public String toClassSortPage(@PathVariable("id") Long id,Model model){
        Week week = weekHelper.getGlobalWeek();
        Course course=new Course();
        course.setClassId(id);
        List<CourseVO> list = courseService.courseList(course);
        model.addAttribute("id",id);
        model.addAttribute("courseVO",new CourseVO());
        model.addAttribute("week",week);
        model.addAttribute("sortedCourses",list);
        model.addAttribute("grades",valueSetHelper.getValueList(ValueSetHelper.GRADE));
        model.addAttribute("sortConditions",valueSetHelper.getValueList(ValueSetHelper.SORT_CONDITION));
        return "admin/class-sorted/sort-by-class";
    }

    /**
     * 查询当前课程当前班级一周内没有冲突的时间
     * @param model
     * @param courseId
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('list-course')")
    @GetMapping("/no-conflict-week")
    public String selectNoConflictWeek(Model model,@RequestParam("courseId") Long courseId,@RequestParam("id") Long id){
        List<Week> noConflictWeeks =new ArrayList<>();
        List<Week> weeks=weekHelper.getGlobalWeeks();
        weeks.forEach(week -> {
            //如果没有冲突，加入需要返回的集合之中
            if(scheduleService.validateConflict(courseId,week)){
                noConflictWeeks.add(week);
            }
        });
        model.addAttribute("courseId",courseId);
        model.addAttribute("noConflictWeek",noConflictWeeks);
        return toClassSortPage(id,model);
    }
    /**
     * 时间表添加
     * @param schedule
     * @return
     */
    @PreAuthorize("hasAuthority('add-schedule')")
    @PostMapping("/schedule")
    public String addSchedule(Schedule schedule,@RequestParam("id") Long id){
        scheduleService.insertSchedule(schedule);
        return "redirect:/auto-sort/classDto/"+id;
    }
    /**
     * 时间表删除
     * @param id
     * @return
     */
    @DeleteMapping("/schedule/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('delete-schedule')")
    public ResponseEntity<String> deleteScheduleByCourseId(@PathVariable("id")Long id){
        Schedule schedule = new Schedule();
        schedule.setCourseId(id);
        //todo 此处应该做课程删除操作
        scheduleService.deleteSchedule(scheduleService.selectOne(schedule).getTimeId());
        return ResponseEntity.ok("success");
    }
    /**
     * 课表查询
     * @param model
     * @param courseVO
     * @return
     */
    @PreAuthorize("hasAuthority('list-course')")
    @GetMapping("/course-sorted")
    public String listSorted(Model model,CourseVO courseVO){
        log.info("Select by condition:"+courseVO.getCondition());
        courseVO.convertCondition(valueSetHelper);
        Week week = weekHelper.getGlobalWeek();
        Course course=new Course();
        BeanUtils.copyProperties(courseVO,course);
        List<CourseVO> list = courseService.courseList(course);
        model.addAttribute("courseVO",courseVO);
        model.addAttribute("week",week);
        model.addAttribute("sortedCourses",list);
        model.addAttribute("grades",valueSetHelper.getValueList(ValueSetHelper.GRADE));
        model.addAttribute("sortConditions",valueSetHelper.getValueList(ValueSetHelper.SORT_CONDITION));
        return "admin/course-sorted/sorted";
    }
}
