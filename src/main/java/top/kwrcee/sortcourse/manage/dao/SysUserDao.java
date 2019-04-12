package top.kwrcee.sortcourse.manage.dao;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.kwrcee.sortcourse.manage.entities.SysPermission;
import top.kwrcee.sortcourse.manage.entities.SysRole;
import top.kwrcee.sortcourse.manage.entities.SysUser;
import top.kwrcee.sortcourse.manage.mapper.SysPermissionMapper;
import top.kwrcee.sortcourse.manage.mapper.SysRoleMapper;
import top.kwrcee.sortcourse.manage.mapper.SysUserMapper;
import top.kwrcee.sortcourse.manage.service.SysPermissionService;
import top.kwrcee.sortcourse.manage.service.SysRoleService;
import top.kwrcee.sortcourse.manage.service.SysUserService;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Repository
public class SysUserDao {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    public SysUser selectOne(SysUser sysUser) {
        log.info("从数据库中查询用户");
        //将该用户拥有的角色，角色拥有的资源都查询出来存入redis
        SysUser user =sysUserMapper.selectOne(sysUser);
        SysRole role =new SysRole();
        role.setUserId(user.getId());
        List<SysRole> roleList = sysRoleMapper.select(role);
        roleList.forEach(r->{
            SysPermission sysPermission=new SysPermission();
            sysPermission.setRoleId(r.getId());
            r.setPermissionList(sysPermissionMapper.select(sysPermission));
        });
        user.setRoleList(roleList);
        return user;
    }

    /**
     * 注册用户
     * @param user
     */
    public SysUser addUser(SysUser user) {
        sysUserMapper.insert(user);
        return user;
    }


    //-------------------------------------------------------------------------


}
