package top.kwrcee.sortcourse.manage.entities;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import lombok.Data;
import lombok.ToString;
import top.kwrcee.sortcourse.manage.mapper.CourseMapper;
import top.kwrcee.sortcourse.manage.service.CourseService;
import top.kwrcee.sortcourse.manage.utils.Constants;
import top.kwrcee.sortcourse.manage.vo.CourseVO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

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
    private Long grade;

//
// 非数据库字段
// ------------------------------------------------------------------------------
    @Transient
    private Integer sortStatusFlag;

    /**
     * 计算班级排课状态
     * @param courseService
     */
    public void computeSortFlag(CourseService courseService) {
        Course course = new Course();
        course.setClassId(classId);
        List<Course> list = courseService.select(course);
        Boolean allYES = true;
        Boolean allNO = true;
        for (Course co : list) {
            if (Constants.Flag.YES.equals(co.getSortStatusFlag())) {
                allYES = false;
            } else {
                allNO = false;
            }
        }
        if (allYES) {
            sortStatusFlag = Constants.Flag.NO;
        } else if (allNO) {
            sortStatusFlag = Constants.Flag.YES;
        } else {
            sortStatusFlag = -1;
        }
    }
//
// getter/setter
// ------------------------------------------------------------------------------

}
