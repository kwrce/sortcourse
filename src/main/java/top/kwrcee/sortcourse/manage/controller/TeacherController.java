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
import top.kwrcee.sortcourse.manage.entities.Teacher;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.service.TeacherService;

import java.util.List;

/**
 *  管理 API
 *
 * @author guangrui.liu@hand-china.com
 * @date 2019-03-16 14:11:23
 */
@Controller
@RequestMapping("/manage-teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询教师列表
     * @param model
     * @param pageRequest
     * @param teacher
     * @return
     */
    @PreAuthorize("hasAuthority('list-teacher')")
    @GetMapping("/teachers")
    public String search(Model model, @SortDefault(value = Teacher.FIELD_TEACHER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest, Teacher teacher){
        pageRequest.setSize(10);
        Page<Teacher> pageInfo=teacherService.pageTeacherList(pageRequest,teacher);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/teacher/teacher-list";
    }
    /**
     * 教师添加
     * @param teacher
     * @return
     */
    @PreAuthorize("hasAuthority('add-teacher')")
    @PostMapping("/teacher")
    public String addTeacher(Teacher teacher){
        teacherService.insert(teacher);
        return "redirect:/manage-teacher/teachers";
    }

    /**
     * 教师删除
     * @param id
     * @return
     */
    @DeleteMapping("/teacher/{id}")
    @ResponseBody
    //@PreAuthorize("hasAuthority('delete-teacher')")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id")Long id){
        System.out.println("has deleted");
        teacherService.deleteByPrimaryKey(id);
        return ResponseEntity.ok("success");
    }
    /**
     * 教师批量删除
     * @param ids
     * @return list
     */
    @PostMapping("/teachers/delete")
    @ResponseBody
    @PreAuthorize("hasAuthority('delete-teacher')")
    public ResponseEntity<String> deleteTeachers(@RequestParam (value = "ids",required = false) List<Long> ids){
        System.out.println(ids);
        String status=teacherService.deleteList(ids);
        return ResponseEntity.ok(status);
    }
    /**
     * 来到修改页面，查出当前信息，然后回显
     * @param id
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('update-teacher')")
    @GetMapping("/teacher/{id}")
    public String toEditPage(@PathVariable("id") Long id,Model model){
        Teacher teacher = teacherService.selectByPrimaryKey(id) ;
        model.addAttribute("teacher",teacher);
        return "admin/teacher/teacher-detail";
    }
    /**
     * 教师更新
     * @param teacher
     * @return
     */
    @PreAuthorize("hasAuthority('update-teacher')")
    @PutMapping("/teacher")
    public String updateTeacher(Teacher teacher){
        System.out.println(teacher);
        Integer flag=teacherService.updateByPrimaryKey(teacher);
        return "redirect:/manage-teacher/teachers";
    }
    /**
     * 去添加界面
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('add-teacher')")
    @GetMapping("/teacher")
    public String toAddPage(Model model){
        ValueSet valueSet =new ValueSet();
        return "admin/teacher/teacher-add";
    }

}
