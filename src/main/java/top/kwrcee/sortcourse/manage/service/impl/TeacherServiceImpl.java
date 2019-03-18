package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kwrcee.sortcourse.manage.entities.Teacher;
import top.kwrcee.sortcourse.manage.mapper.TeacherMapper;
import top.kwrcee.sortcourse.manage.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Page<Teacher> pageTeacherList(PageRequest pageRequest, Teacher teacher) {
        return PageHelper.doPageAndSort(pageRequest,()->teacherMapper.selectByTeacher(teacher));
    }
}
