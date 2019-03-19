package top.kwrcee.sortcourse.manage.mapper;


import io.choerodon.mybatis.common.BaseMapper;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.vo.CourseVO;

import java.util.List;

/**
 * Mapper
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */

public interface CourseMapper extends BaseMapper<Course> {
    /**
     * 分页模糊查询教室信息
     * @param course
     * @return
     */
    List<CourseVO> selectByCourse(Course course);
}

