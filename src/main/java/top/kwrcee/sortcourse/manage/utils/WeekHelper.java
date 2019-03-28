package top.kwrcee.sortcourse.manage.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.service.ValueSetService;
import top.kwrcee.sortcourse.manage.vo.Week;

/**
 * 获取值集数据中一周上课的天数课一天上课的节数
 */
@Component
public class WeekHelper {
    @Autowired
    private ValueSetService valueSetService;
    public Week getGlobalWeek(){
        ValueSet weekValue=new ValueSet();
        //获取一周内的天数
        weekValue.setName(Constants.ValueSet.WEEK_DAY);
        ValueSet dayValue=valueSetService.selectOne(weekValue);
        weekValue.setName(Constants.ValueSet.DAY_TIME);
        //获取一天内的节数
        ValueSet timeValue=valueSetService.selectOne(weekValue);
        Integer day=Integer.valueOf(dayValue.getValue());
        Integer time=Integer.valueOf(timeValue.getValue());
        return new Week(day,time);
    }
}
