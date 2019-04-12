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
import top.kwrcee.sortcourse.manage.service.CourseService;

import java.util.List;

@Service
public class ClassDtoServiceImpl extends BaseServiceImpl<ClassDto> implements ClassDtoService {
    @Autowired
    ClassDtoMapper classDtoMapper;
    @Autowired
    CourseService courseService;

    @Override
    public Page<ClassDto> pageClassDtoList(PageRequest pageRequest, ClassDto classDto) {
        return PageHelper.doPageAndSort(pageRequest,()->{
            List<ClassDto> classDtos = classDtoMapper.selectByClassDto(classDto);
            //设置班级实体中的排课标识
            classDtos.forEach(cl->{
                cl.computeSortFlag(courseService);
            });
            return classDtos;
        });
    }

    @Override
    public String deleteList(List<Long> ids) {
        ids.forEach(id->classDtoMapper.deleteByPrimaryKey(id));
        return "success";
    }
}
