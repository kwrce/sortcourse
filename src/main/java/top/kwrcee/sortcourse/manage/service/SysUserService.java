package top.kwrcee.sortcourse.manage.service;

import io.choerodon.mybatis.service.BaseService;
import top.kwrcee.sortcourse.manage.entities.SysUser;

public interface SysUserService extends BaseService<SysUser> {
    SysUser selectOne(SysUser var1);
}
