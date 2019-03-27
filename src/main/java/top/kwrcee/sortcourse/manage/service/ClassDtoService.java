package top.kwrcee.sortcourse.manage.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseService;
import top.kwrcee.sortcourse.manage.entities.ClassDto;

import java.util.List;

public interface ClassDtoService extends BaseService<ClassDto> {

    Page<ClassDto> pageClassDtoList(PageRequest pageRequest, ClassDto classDto);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    String deleteList(List<Long> ids);
}
