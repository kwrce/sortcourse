package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import top.kwrcee.sortcourse.manage.dao.SysUserDao;
import top.kwrcee.sortcourse.manage.entities.SysUser;
import top.kwrcee.sortcourse.manage.service.SysUserService;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    private PasswordEncoder passwordEncoder; //security提供的加密接口

    @Override
    @Cacheable(cacheNames = "authority", key = "#record.username")
    public SysUser selectOne(SysUser record) {
        return this.sysUserDao.selectOne(record);
    }

    @Override
    public SysUser addUser(SysUser user) {
        if (user.getUsername() != null && user.getPassword() != null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            sysUserDao.addUser(user);
        }
        else
            user = null;
        return user;
    }
}
