package top.kwrcee.sortcourse.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.utils.WeekHelper;
import top.kwrcee.sortcourse.manage.vo.CourseVO;
import top.kwrcee.sortcourse.manage.vo.Week;

import java.util.List;

@Controller
@RequestMapping("/auto-sort")
public class AutoSortCourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    WeekHelper weekHelper;

    @PreAuthorize("hasAuthority('list-course')")
    @PostMapping("/sort")
    public String sortCourse(Model model){
        List<CourseVO> list = courseService.sortCourse();
        model.addAttribute("list",list);
        return "redirect:/auto-sort/course-sorted";
    }
    @PreAuthorize("hasAuthority('list-course')")
    @GetMapping("/course-sorted")
    public String listSorted(Model model){
        Week week = weekHelper.getGlobalWeek();
        List<CourseVO> list = courseService.courseList(new Course());
        model.addAttribute("week",week);
        model.addAttribute("sortedCourses",list);
        return "admin/course-sorted/sorted";
    }
}
