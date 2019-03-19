package top.kwrcee.sortcourse.manage.entities;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    public static final String FIELD_TEACHER_ID = "teacherId";
    public static final String FIELD_ROOM_ID = "roomId";
    public static final String FIELD_CLASS_ID = "classId";
    public static final String FIELD_USAGE_STATUS_FLAG = "usageStatusFlag";

//
// 业务方法(按public protected private顺序排列)
// ------------------------------------------------------------------------------

//
// 数据库字段
// ------------------------------------------------------------------------------
    @Id
    @GeneratedValue
    private Long courseId;
    private String courseName;
    private Long teacherId;
    private Long roomId;
    private Long classId;
    private Integer usageStatusFlag;

//
// 非数据库字段
// ------------------------------------------------------------------------------

//
// getter/setter
// ------------------------------------------------------------------------------


}
