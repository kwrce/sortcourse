package top.kwrcee.sortcourse.manage.mapper;


import io.choerodon.mybatis.common.BaseMapper;
import top.kwrcee.sortcourse.manage.entities.Room;
import top.kwrcee.sortcourse.manage.entities.Teacher;

import java.util.List;

/**
 * Mapper
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */

public interface TeacherMapper extends BaseMapper<Teacher> {
    /**
     * 分页模糊查询教室信息
     * @param teacher
     * @return
     */
    List<Teacher> selectByTeacher(Teacher teacher);
}

