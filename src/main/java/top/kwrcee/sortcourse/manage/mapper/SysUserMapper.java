package top.kwrcee.sortcourse.manage.mapper;


import io.choerodon.mybatis.common.BaseMapper;
import top.kwrcee.sortcourse.manage.entities.SysRole;
import top.kwrcee.sortcourse.manage.entities.SysUser;

/**
 * Mapper
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByName(SysUser sysUser);
}

