package top.kwrcee.sortcourse.manage.entities;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.StringUtils;
import top.kwrcee.sortcourse.manage.mapper.CourseMapper;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.utils.Constants;
import top.kwrcee.sortcourse.manage.vo.CourseVO;
import top.kwrcee.sortcourse.manage.vo.Week;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */
@VersionAudit
@ModifyAudit
@Table(name = "schedule")
@ToString
@Data
@NoArgsConstructor
public class Schedule extends AuditDomain {
    public static final String FIELD_TIME_ID = "timeId";
    public static final String FIELD_COURSE_ID = "courseId";
    public static final String FIELD_COURSE_TIME = "courseTime";
    public static final String FIELD_COURSE_DAY = "courseDay";
    public static final String FIELD_USAGE_STATUS_FLAG = "usageStatusFlag";
//
// 业务方法(按public protected private顺序排列)
// ------------------------------------------------------------------------------
    /**
     * 构造方法
     * @param week
     */
    public Schedule(Week week, CourseVO courseVO) {
        courseTime = week.getTime();
        courseDay = week.getDay();
        courseId = courseVO.getCourseId();
    }

    /**
     * 将前端的weekMeaning值转换为 courseDay 和 courseTime
     */
    public void convertToWeek(){
        if(StringUtils.isEmpty(weekMeaning)){
            return;
        }
        String[] clips = StringUtils.split(weekMeaning, "-");
        courseDay = Integer.valueOf(clips[0]);
        courseTime = Integer.valueOf(clips[1]);
    }
//
// 数据库字段
// ------------------------------------------------------------------------------
    @Id
    @GeneratedValue
    private Long timeId;
    private Long courseId;
    private Integer courseTime;
    private Integer courseDay;
    private Integer usageStatusFlag;
//
// 非数据库字段
// ------------------------------------------------------------------------------
    @Transient
    private String courseName;
    @Transient
    private String weekMeaning;
//
// getter/setter
// ------------------------------------------------------------------------------


}
