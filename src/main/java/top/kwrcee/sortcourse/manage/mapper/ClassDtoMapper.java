package top.kwrcee.sortcourse.manage.mapper;


import io.choerodon.mybatis.common.BaseMapper;
import top.kwrcee.sortcourse.manage.entities.ClassDto;
import top.kwrcee.sortcourse.manage.entities.Teacher;

import java.util.List;

/**
 * Mapper
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */

public interface ClassDtoMapper extends BaseMapper<ClassDto> {
    /**
     * 分页模糊查询教室信息
     * @param classDto
     * @return
     */
    List<ClassDto> selectByClassDto(ClassDto classDto);
}

