package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.kwrcee.sortcourse.manage.dao.SysUserDao;
import top.kwrcee.sortcourse.manage.entities.SysUser;
import top.kwrcee.sortcourse.manage.mapper.SysUserMapper;
import top.kwrcee.sortcourse.manage.service.SysUserService;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;

    @Override
    @Cacheable(cacheNames = "authority", key = "#record.username")
    public SysUser selectOne(SysUser record) {
        return this.sysUserDao.selectOne(record);
    }



}
