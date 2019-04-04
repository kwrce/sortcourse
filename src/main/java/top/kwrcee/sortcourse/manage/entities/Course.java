package top.kwrcee.sortcourse.manage.entities;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import lombok.Data;
import lombok.ToString;
import top.kwrcee.sortcourse.manage.mapper.CourseMapper;
import top.kwrcee.sortcourse.manage.utils.Constants;

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
@Table(name = "course")
@ToString
@Data
public class Course extends AuditDomain {
    public static final String FIELD_COURSE_ID = "courseId";
    public static final String FIELD_COURSE_NAME = "courseName";
    public static final String FIELD_COURSE_NUM = "courseNum";
    public static final String FIELD_COURSE_QUANTITY = "courseQuantity";
    public static final String FIELD_TEACHER_ID = "teacherId";
    public static final String FIELD_ROOM_ID = "roomId";
    public static final String FIELD_CLASS_ID = "classId";
    public static final String FIELD_USAGE_STATUS_FLAG = "usageStatusFlag";
    public static final String FIELD_SORT_STATUS_FLAG = "sortStatusFlag";

//
// 业务方法(按public protected private顺序排列)
// ------------------------------------------------------------------------------
    public void saveLineNum(CourseMapper courseMapper){
        //设置最大行号
        Long lineNum=courseMapper.queryMaxLineNum();
        if(lineNum==null){
            courseNum=Constants.DefaultLongNumber.ONE;
        }else{
            courseNum=lineNum;
        }
    }
//
// 数据库字段
// ------------------------------------------------------------------------------
    @Id
    @GeneratedValue
    private Long courseId;
    private Long courseNum;
    private String courseName;
    private Integer courseQuantity;
    private Long teacherId;
    private Long roomId;
    private Long classId;
    private Integer usageStatusFlag;
    private Integer sortStatusFlag;

//
// 非数据库字段
// ------------------------------------------------------------------------------
    @Transient
    private Integer distinctFlag;
    @Transient
    private Long grade;
//
// getter/setter
// ------------------------------------------------------------------------------


}
