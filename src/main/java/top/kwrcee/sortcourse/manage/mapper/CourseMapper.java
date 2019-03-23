package top.kwrcee.sortcourse.manage.mapper;


import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.vo.CourseVO;
import top.kwrcee.sortcourse.manage.vo.Week;

import java.util.List;

/**
 * Mapper
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */

public interface CourseMapper extends BaseMapper<Course> {
    /**
     * 模糊查询教室信息
     * @param course
     * @return
     */
    List<CourseVO> selectByCourse(Course course);

    /**
     * 模糊查询教室信息（去重）
     * @param course
     * @return
     */
    List<CourseVO> selectByCourseDistinct(Course course);

    /**
     * 查询最大行号
     * @return
     */
    Long queryMaxLineNum();

    List<CourseVO> selectTimeTable(@Param("course") Course course,@Param("week")Week week);
}

