package top.kwrcee.sortcourse.manage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.kwrcee.sortcourse.manage.service.CourseService;

@Controller
public class AdminController {
    @Autowired
    CourseService courseService;

    @GetMapping("/admin")
    public String list (Model model){
        return "admin/index/index";
    }
    /**
     * 欢迎界面
     */
    @GetMapping("/welcome")
    public String welcome (Model model){
        courseService.countCourse(model);
        return "admin/index/welcome";
    }
}
