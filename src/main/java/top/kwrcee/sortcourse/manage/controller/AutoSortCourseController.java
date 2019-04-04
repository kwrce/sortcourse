package top.kwrcee.sortcourse.manage.controller;

import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.utils.ValueSetHelper;
import top.kwrcee.sortcourse.manage.utils.WeekHelper;
import top.kwrcee.sortcourse.manage.vo.CourseVO;
import top.kwrcee.sortcourse.manage.vo.Week;

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

    /**
     * 排课
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
