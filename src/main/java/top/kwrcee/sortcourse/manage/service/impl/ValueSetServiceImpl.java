package top.kwrcee.sortcourse.manage.service.impl;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.mapper.ValueSetMapper;
import top.kwrcee.sortcourse.manage.service.ValueSetService;

import java.util.List;


@Service
public class ValueSetServiceImpl extends BaseServiceImpl<ValueSet> implements ValueSetService {
    @Autowired
    ValueSetMapper valueSetMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String  deleteList(List<Long> ids) {
        ids.forEach(id ->valueSetMapper.deleteByPrimaryKey(id));
        return "success";
    }

    @Override
    public Page<ValueSet> pageValueSetList(PageRequest pageRequest, ValueSet valueSet) {
        return PageHelper.doPageAndSort(pageRequest,()->valueSetMapper.selectByValueSet(valueSet));
    }
}
