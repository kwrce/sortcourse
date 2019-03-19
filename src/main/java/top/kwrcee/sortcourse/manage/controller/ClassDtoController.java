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
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.service.ClassDtoService;
import top.kwrcee.sortcourse.manage.service.ValueSetService;
import top.kwrcee.sortcourse.manage.utils.Constants;

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
    private ValueSetService valueSetService;

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
    //@PreAuthorize("hasAuthority('delete-classDto')")
    public ResponseEntity<String> deleteClassDto(@PathVariable("id")Long id){
        System.out.println("has deleted");
        classDtoService.deleteByPrimaryKey(id);
        return ResponseEntity.ok("success");
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
        Integer flag=classDtoService.updateByPrimaryKey(classDto);
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
        ValueSet valueSet =new ValueSet();
        //查询楼层值集
        valueSet.setName(Constants.ValueSet.BUILDING_NAME);
        model.addAttribute("buildings",valueSetService.select(valueSet));
        return "admin/classDto/classDto-add";
    }

}
