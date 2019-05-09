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
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.service.ValueSetService;
import top.kwrcee.sortcourse.manage.utils.Constants;
import top.kwrcee.sortcourse.manage.utils.ValueSetHelper;

import java.util.List;


/**
 *  管理 API
 *
 * @author guangrui.liu@hand-china.com
 * @date 2019-01-29 14:11:23
 */
@Controller
@RequestMapping("/manage-valueSet")
public class ValueSetController {

    @Autowired
    private ValueSetService valueSetService;
    @Autowired
    private ValueSetHelper valueSetHelper;

    /**
     * 查询值集列表
     * @param model
     * @param pageRequest
     * @param valueSet
     * @return
     */
    @PreAuthorize("hasAuthority('"+Constants.AuthorityPermission.ROOM_LIST+"')")
    @GetMapping("/valueSets")
    public String search(Model model, @SortDefault(value = ValueSet.FIELD_NAME,
            direction = Sort.Direction.DESC) PageRequest pageRequest, ValueSet valueSet){
        pageRequest.setSize(10);
        Page<ValueSet> pageInfo=valueSetService.pageValueSetList(pageRequest,valueSet);
        model.addAttribute("pageInfo",pageInfo);
        //查询楼号的值集
        model.addAttribute("buildings",valueSetHelper.getValueList(ValueSetHelper.BUILDING_NAME));
        return "admin/valueSet/valueSet-list";
    }
    /**
     * 值集添加
     * @param valueSet
     * @return
     */
    @PreAuthorize("hasAuthority('add-valueSet')")
    @PostMapping("/valueSet")
    public String addValueSet(ValueSet valueSet){
        valueSetService.insert(valueSet);
        return "redirect:/manage-valueSet/valueSets";
    }

    /**
     * 值集删除
     * @param id
     * @return
     */
    @DeleteMapping("/valueSet/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('delete-valueSet')")
    public ResponseEntity<String> deleteValueSet(@PathVariable("id")Long id){
        System.out.println("has deleted");
        valueSetService.deleteByPrimaryKey(id);
        return ResponseEntity.ok("success");
    }
    /**
     * 值集批量删除
     * @param ids
     * @return list
     */
    @PostMapping("/valueSets/delete")
    @ResponseBody
    @PreAuthorize("hasAuthority('delete-valueSet')")
    public ResponseEntity<String> deleteValueSets(@RequestParam (value = "ids",required = false) List<Long> ids){
        System.out.println(ids);
        String status=valueSetService.deleteList(ids);
        return ResponseEntity.ok(status);
    }
    /**
     * 来到修改页面，查出当前信息，然后回显
     * @param id
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('update-valueSet')")
    @GetMapping("/valueSet/{id}")
    public String toEditPage(@PathVariable("id") Long id,Model model){
        ValueSet valueSet = valueSetService.selectByPrimaryKey(id) ;
        model.addAttribute("valueSet",valueSet);
        //查询楼层的值集
        model.addAttribute("buildings",valueSetHelper.getValueList(ValueSetHelper.BUILDING_NAME));
        return "admin/valueSet/valueSet-detail";
    }
    /**
     * 值集更新
     * @param valueSet
     * @return
     */
    @PreAuthorize("hasAuthority('update-valueSet')")
    @PutMapping("/valueSet")
    public String updateValueSet(ValueSet valueSet){
        System.out.println(valueSet);
        Integer flag=valueSetService.updateByPrimaryKey(valueSet);
        return "redirect:/manage-valueSet/valueSets";
    }
    /**
     * 去添加界面
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('add-valueSet')")
    @GetMapping("/valueSet")
    public String toAddPage(Model model){
        //查询楼层值集
        model.addAttribute("buildings",valueSetHelper.getValueList(ValueSetHelper.BUILDING_NAME));
        return "admin/valueSet/valueSet-add";
    }

}
