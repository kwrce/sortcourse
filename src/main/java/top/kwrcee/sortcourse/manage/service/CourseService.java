package top.kwrcee.sortcourse.manage.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseService;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.vo.CourseVO;

public interface CourseService extends BaseService<Course> {

    Page<CourseVO> pageCourseList(PageRequest pageRequest, Course Course);
}
