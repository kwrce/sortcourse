package top.kwrcee.sortcourse.manage.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseService;
import top.kwrcee.sortcourse.manage.entities.ClassDto;

public interface ClassDtoService extends BaseService<ClassDto> {

    Page<ClassDto> pageClassDtoList(PageRequest pageRequest, ClassDto classDto);
}
