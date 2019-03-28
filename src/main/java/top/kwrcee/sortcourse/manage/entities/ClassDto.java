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
@Table(name = "class_dto")
@Data
@ToString
public class ClassDto extends AuditDomain {
    public static final String FIELD_CLASS_ID = "classId";
    public static final String FIELD_MAJOR = "major";
    public static final String FIELD_CLASS_NAME = "className";
    public static final String FIELD_INSTITUTE = "institute";
    public static final String FIELD_CLASS_MASTER = "classMaster";
    public static final String FIELD_STUDENT_QUANTITY = "studentQuantity";
    public static final String FIELD_USAGE_STATUS_FLAG = "usageStatusFlag";
    public static final String FIELD_GRADE = "grade";

//
// 业务方法(按public protected private顺序排列)
// ------------------------------------------------------------------------------

//
// 数据库字段
// ------------------------------------------------------------------------------
    @Id
    @GeneratedValue
    private Long classId;
    private String major;
    private String className;
    private String institute;
    private String classMaster;
    private Integer studentQuantity;
    private Integer usageStatusFlag;
    private Integer grade;

//
// 非数据库字段
// ------------------------------------------------------------------------------

//
// getter/setter
// ------------------------------------------------------------------------------

}
