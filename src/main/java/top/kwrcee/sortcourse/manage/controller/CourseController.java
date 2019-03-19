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
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.service.ValueSetService;
import top.kwrcee.sortcourse.manage.utils.Constants;
import top.kwrcee.sortcourse.manage.vo.CourseVO;

/**
 *  管理 API
 *
 * @author guangrui.liu@hand-china.com
 * @date 2019-03-19 14:11:23
 */
@Controller
@RequestMapping("/manage-course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private ValueSetService valueSetService;

    /**
     * 查询课程列表
     * @param model
     * @param pageRequest
     * @param course
     * @return
     */
    @PreAuthorize("hasAuthority('list-course')")
    @GetMapping("/courses")
    public String search(Model model, @SortDefault(value = Course.FIELD_COURSE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest, Course course){
        pageRequest.setSize(10);
        Page<CourseVO> pageInfo=courseService.pageCourseList(pageRequest,course);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/course/course-list";
    }
    /**
     * 课程添加
     * @param course
     * @return
     */
    @PreAuthorize("hasAuthority('add-course')")
    @PostMapping("/course")
    public String addCourse(Course course){
        courseService.insert(course);
        return "redirect:/manage-course/courses";
    }

    /**
     * 课程删除
     * @param id
     * @return
     */
    @DeleteMapping("/course/{id}")
    @ResponseBody
    //@PreAuthorize("hasAuthority('delete-course')")
    public ResponseEntity<String> deleteCourse(@PathVariable("id")Long id){
        System.out.println("has deleted");
        courseService.deleteByPrimaryKey(id);
        return ResponseEntity.ok("success");
    }
    /**
     * 来到修改页面，查出当前信息，然后回显
     * @param id
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('update-course')")
    @GetMapping("/course/{id}")
    public String toEditPage(@PathVariable("id") Long id,Model model){
        Course course = courseService.selectByPrimaryKey(id) ;
        model.addAttribute("course",course);
        return "admin/course/course-detail";
    }
    /**
     * 课程更新
     * @param course
     * @return
     */
    @PreAuthorize("hasAuthority('update-course')")
    @PutMapping("/course")
    public String updateCourse(Course course){
        System.out.println(course);
        Integer flag=courseService.updateByPrimaryKey(course);
        return "redirect:/manage-course/courses";
    }
    /**
     * 去添加界面
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('add-course')")
    @GetMapping("/course")
    public String toAddPage(Model model){
        ValueSet valueSet =new ValueSet();
        return "admin/course/course-add";
    }

}
