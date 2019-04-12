package top.kwrcee.sortcourse.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.kwrcee.sortcourse.manage.entities.SysUser;
import top.kwrcee.sortcourse.manage.service.SysUserService;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

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
     * 用户注册
     * @return
     */
    @PostMapping("register")
    public String signIn(SysUser user){
        sysUserService.addUser(user);
        return "redirect: /admin";
    }
    /**
     * 来到用户注册界面
     * @return
     */
    @GetMapping("register")
    public String toSignIn(){
        return "register";
    }


}
