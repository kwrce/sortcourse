package top.kwrcee.sortcourse.manage.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.service.ValueSetService;

import java.util.List;

/**
 * 通过编码获取值集
 */
@Component
public class ValueSetHelper {
    /**
     * 楼号
     */
    public static final String BUILDING_NAME = "building";
    /**
     * 一周上课的天数
     */
    public static final String WEEK_DAY = "week-day";
    /**
     * 一天上课的天数
     */
    public static final String DAY_TIME = "day-time";
    /**
     * 年级
     */
    public static final String GRADE = "grade";
    /**
     * 排课条件查询
     */
    public static final String SORT_CONDITION = "sort-condition";

    @Autowired
    ValueSetService valueSetService;

    public List<ValueSet> getValueList(String code) {
        ValueSet valueSet =new ValueSet();
        valueSet.setName(code);
        return valueSetService.select(valueSet);
    }
}
