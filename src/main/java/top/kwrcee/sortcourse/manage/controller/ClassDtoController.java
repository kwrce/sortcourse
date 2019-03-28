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
import top.kwrcee.sortcourse.manage.entities.ClassDto;
import top.kwrcee.sortcourse.manage.service.ClassDtoService;
import top.kwrcee.sortcourse.manage.utils.ValueSetHelper;

import java.util.List;

/**
 *  管理 API
 *
 * @author guangrui.liu@hand-china.com
 * @date 2019-03-18 14:11:23
 */
@Controller
@RequestMapping("/manage-classDto")
public class ClassDtoController {

    @Autowired
    private ClassDtoService classDtoService;
    @Autowired
    private ValueSetHelper valueSetHelper;

    /**
     * 查询班级列表
     * @param model
     * @param pageRequest
     * @param classDto
     * @return
     */
    @PreAuthorize("hasAuthority('list-classDto')")
    @GetMapping("/classDtos")
    public String search(Model model, @SortDefault(value = ClassDto.FIELD_CLASS_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest, ClassDto classDto){
        pageRequest.setSize(10);
        Page<ClassDto> pageInfo=classDtoService.pageClassDtoList(pageRequest,classDto);
        model.addAttribute("grades",valueSetHelper.getValueList(ValueSetHelper.GRADE));
        model.addAttribute("pageInfo",pageInfo);
        return "admin/classDto/classDto-list";
    }
    /**
     * 班级添加
     * @param classDto
     * @return
     */
    @PreAuthorize("hasAuthority('add-classDto')")
    @PostMapping("/classDto")
    public String addClassDto(ClassDto classDto){
        classDtoService.insert(classDto);
        return "redirect:/manage-classDto/classDtos";
    }

    /**
     * 班级删除
     * @param id
     * @return
     */
    @DeleteMapping("/classDto/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('delete-classDto')")
    public ResponseEntity<String> deleteClassDto(@PathVariable("id")Long id){
        System.out.println("has deleted");
        classDtoService.deleteByPrimaryKey(id);
        return ResponseEntity.ok("success");
    }
    /**
     * 班级批量删除
     * @param ids
     * @return list
     */
    @PostMapping("/classDtos/delete")
    @ResponseBody
    @PreAuthorize("hasAuthority('delete-classDto')")
    public ResponseEntity<String> deleteClassDtos(@RequestParam (value = "ids",required = false) List<Long> ids){
        System.out.println(ids);
        String status=classDtoService.deleteList(ids);
        return ResponseEntity.ok(status);
    }
    /**
     * 来到修改页面，查出当前信息，然后回显
     * @param id
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('update-classDto')")
    @GetMapping("/classDto/{id}")
    public String toEditPage(@PathVariable("id") Long id,Model model){
        ClassDto classDto = classDtoService.selectByPrimaryKey(id) ;
        model.addAttribute("classDto",classDto);
        model.addAttribute("grades",valueSetHelper.getValueList(ValueSetHelper.GRADE));
        return "admin/classDto/classDto-detail";
    }
    /**
     * 班级更新
     * @param classDto
     * @return
     */
    @PreAuthorize("hasAuthority('update-classDto')")
    @PutMapping("/classDto")
    public String updateClassDto(ClassDto classDto){
        System.out.println(classDto);
        classDtoService.updateByPrimaryKey(classDto);
        return "redirect:/manage-classDto/classDtos";
    }
    /**
     * 去添加界面
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('add-classDto')")
    @GetMapping("/classDto")
    public String toAddPage(Model model){
        //查询年级值集
        model.addAttribute("grades",valueSetHelper.getValueList(ValueSetHelper.GRADE));
        return "admin/classDto/classDto-add";
    }

}
