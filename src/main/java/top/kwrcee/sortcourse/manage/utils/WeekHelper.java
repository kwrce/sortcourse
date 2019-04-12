package top.kwrcee.sortcourse.manage.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.kwrcee.sortcourse.manage.entities.ValueSet;
import top.kwrcee.sortcourse.manage.service.ValueSetService;
import top.kwrcee.sortcourse.manage.vo.Week;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取值集数据中一周上课的天数课一天上课的节数
 */
@Component
public class WeekHelper {
    @Autowired
    private ValueSetService valueSetService;

    /**
     * 获取当前一周上课的天数和一天上课的节数
     * @return
     */
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

    /**
     * 获取当前一周天数和节数的week数组
     * @return
     */
    public List<Week> getGlobalWeeks(){
        Week globalWeek = getGlobalWeek();
        List<Week> weeks = new ArrayList<>();
        //从值集中获取一周的课程数  遍历week集合
        for (int i = 0; i < globalWeek.getDay(); i++) {
            for (int j = 0; j < globalWeek.getTime(); j++) {
                Week week = new Week();
                week.setDay(i + 1);
                week.setTime(j + 1);
                weeks.add(week);
            }
        }
        return weeks;
    }
}
