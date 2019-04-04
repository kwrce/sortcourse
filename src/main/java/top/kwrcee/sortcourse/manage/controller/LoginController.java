package top.kwrcee.sortcourse.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.kwrcee.sortcourse.manage.entities.SysUser;
import top.kwrcee.sortcourse.manage.service.SysPermissionService;
import top.kwrcee.sortcourse.manage.service.SysRoleService;
import top.kwrcee.sortcourse.manage.service.SysUserService;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping({"login","/","/index"})
    public String login(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/admin";
        }
        return "login";
    }

    @RequestMapping("login-error")
    public String loginError(Model model){
        model.addAttribute("msg", "密码错误");
        return "login";
    }

    @RequestMapping("dashboard")
    public String main(){
        return "dashboard";
    }

    /**
     * 将用户信息刷新到缓存
     * @return
     */
    @ResponseBody
    @GetMapping("test")
    public String test(){
        SysUser sysUser =new SysUser();
        sysUser.setUsername("admin");
        return "sysUserService:"+sysUserService.selectAll().toString()+"/" +
                "SysRoleService:"+sysRoleService.selectAll().toString()+"/" +
                "sysPermissionService:"+sysPermissionService.selectAll().toString()+"/" +
                "sysUserService_INFO:"+sysUserService.selectOne(sysUser);
    }

}
