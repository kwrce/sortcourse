package top.kwrcee.sortcourse.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.vo.CourseVO;

import java.util.List;

@Controller
@RequestMapping("/auto-sort")
public class AutoSortCourseController {
    @Autowired
    CourseService courseService;

    @PreAuthorize("hasAuthority('list-course')")
    @GetMapping("/sort")
    public ResponseEntity<List<CourseVO>> sortCourse(){
        List<CourseVO> list = courseService.sortCourse();
        return ResponseEntity.ok(list);
    }
}
