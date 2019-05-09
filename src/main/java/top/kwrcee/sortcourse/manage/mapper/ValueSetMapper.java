package top.kwrcee.sortcourse.manage.mapper;


import io.choerodon.mybatis.common.BaseMapper;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.entities.ValueSet;

import java.util.List;

/**
 * Mapper
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */

public interface ValueSetMapper extends BaseMapper<ValueSet> {
    /**
     * 分页模糊查询值集信息
     * @param valueSet
     * @return
     */
    List<ValueSet> selectByValueSet(ValueSet valueSet);
}

