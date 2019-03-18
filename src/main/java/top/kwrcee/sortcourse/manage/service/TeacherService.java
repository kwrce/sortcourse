package top.kwrcee.sortcourse.manage.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseService;
import top.kwrcee.sortcourse.manage.entities.Room;
import top.kwrcee.sortcourse.manage.entities.Teacher;

import java.util.List;

public interface TeacherService extends BaseService<Teacher> {

    Page<Teacher> pageTeacherList(PageRequest pageRequest, Teacher teacher);
}
