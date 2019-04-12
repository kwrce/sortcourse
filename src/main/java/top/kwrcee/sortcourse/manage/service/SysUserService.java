package top.kwrcee.sortcourse.manage.service;

import io.choerodon.mybatis.service.BaseService;
import top.kwrcee.sortcourse.manage.entities.SysUser;

public interface SysUserService extends BaseService<SysUser> {
    /**
     * 查询用户信息
     * @param var1
     * @return
     */
    SysUser selectOne(SysUser var1);

    /**
     * 注册用户
     * @return
     */
    SysUser addUser(SysUser user);
}
