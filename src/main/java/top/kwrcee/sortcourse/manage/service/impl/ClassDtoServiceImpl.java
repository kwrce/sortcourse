package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kwrcee.sortcourse.manage.entities.ClassDto;
import top.kwrcee.sortcourse.manage.mapper.ClassDtoMapper;
import top.kwrcee.sortcourse.manage.service.ClassDtoService;

@Service
public class ClassDtoServiceImpl extends BaseServiceImpl<ClassDto> implements ClassDtoService {
    @Autowired
    ClassDtoMapper classDtoMapper;

    @Override
    public Page<ClassDto> pageClassDtoList(PageRequest pageRequest, ClassDto classDto) {
        return PageHelper.doPageAndSort(pageRequest,()->classDtoMapper.selectByClassDto(classDto));
    }
}
