package top.kwrcee.sortcourse.manage.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.mapper.CourseMapper;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.vo.CourseVO;

@Service
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public Page<CourseVO> pageCourseList(PageRequest pageRequest, Course course) {
        return PageHelper.doPageAndSort(pageRequest,()->courseMapper.selectByCourse(course));
    }
}
