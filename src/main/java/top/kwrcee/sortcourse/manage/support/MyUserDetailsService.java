package top.kwrcee.sortcourse.manage.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.kwrcee.sortcourse.manage.entities.SysPermission;
import top.kwrcee.sortcourse.manage.entities.SysRole;
import top.kwrcee.sortcourse.manage.entities.SysUser;
import top.kwrcee.sortcourse.manage.service.SysPermissionService;
import top.kwrcee.sortcourse.manage.service.SysRoleService;
import top.kwrcee.sortcourse.manage.service.SysUserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserService userService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser t= new SysUser();
        t.setUsername(username);
        //获取用户信息
        SysUser sysUser =sysUserService.selectOne(t);
        if (null == sysUser) {
            throw new UsernameNotFoundException(username);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        SysRole l = new SysRole();
        l.setUserId(sysUser.getId());
        //获取用户角色信息
        List<SysRole> roles=sysRoleService.select(l);
        for (SysRole role : roles) {
            SysPermission k=new SysPermission();
            k.setRoleId(role.getId());
            //获取角色权限
            List<SysPermission> permissions = sysPermissionService.select(k);
            for (SysPermission permission : permissions) {
                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
            }
        }

        return new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
    }
}
