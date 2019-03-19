package top.kwrcee.sortcourse.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.kwrcee.sortcourse.manage.entities.SysUser;
import top.kwrcee.sortcourse.manage.service.SysPermissionService;
import top.kwrcee.sortcourse.manage.service.SysRoleService;
import top.kwrcee.sortcourse.manage.service.SysUserService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping("login")
    public String login(Model model){
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
