package top.kwrcee.sortcourse.manage.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseService;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.vo.CourseVO;

import java.util.List;

public interface CourseService extends BaseService<Course> {
    /**
     * 分页汇总查询
     * @param pageRequest
     * @param course
     * @return
     */
    Page<CourseVO> pageCourseList(PageRequest pageRequest, Course course);

    /**
     * 不分页汇总查询
     * @param course
     * @return
     */
    List<CourseVO> courseList(Course course);


    /**
     * 更新课程信息
     * @param course
     * @return
     */
    void updateCourse(Course course);

    /**
     * 增加课程信息
     * @param course
     */
    void insertCourse(Course course);

    /**
     * 排课操作
     * @return
     */
    List<CourseVO> sortCourse();

    /**
     * 批量删除
     * @param nums
     * @return
     */
    String deleteList(List<Long> nums);
}
