package top.kwrcee.sortcourse.manage.vo;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import lombok.Data;
import lombok.ToString;
import top.kwrcee.sortcourse.manage.entities.Course;
import top.kwrcee.sortcourse.manage.mapper.CourseMapper;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 * @author guangrui.liu@hand-china.com 2019-01-29 14:11:23
 */
@ToString
@Data
public class CourseVO extends AuditDomain {
    public static final String FIELD_COURSE_ID = "courseId";
    public static final String FIELD_COURSE_NAME = "courseName";
    public static final String FIELD_TEACHER_ID = "teacherId";
    public static final String FIELD_ROOM_ID = "roomId";
    public static final String FIELD_CLASS_ID = "classId";
    public static final String FIELD_USAGE_STATUS_FLAG = "usageStatusFlag";
    public static final String FIELD_STATUS_FLAG = "sortStatusFlag";


//
// 业务方法(按public protected private顺序排列)
// ------------------------------------------------------------------------------

    /**
     * 冲突校验
     * @param courseMapper
     * @param week
     * @return
     */
    public Boolean validateConflict(CourseMapper courseMapper,Week week) {
        //校验时间和老师是否冲突
        Course validate = new Course();
        validate.setTeacherId(teacherId);
        List<CourseVO> timeList=courseMapper.selectTimeTable(validate,week);
        if(timeList.size()>0){
            return false;
        }
        //校验时间和班级是否冲突
        validate=new Course();
        validate.setClassId(classId);
        List<CourseVO> classList=courseMapper.selectTimeTable(validate,week);
        if (classList.size()>0){
            return false;
        }
        //校验时间和教室是否冲突
        validate=new Course();
        validate.setRoomId(roomId);
        List<CourseVO> roomList=courseMapper.selectTimeTable(validate,week);
        if(roomList.size()>0){
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseVO)) return false;
        CourseVO courseVO = (CourseVO) o;
        return Objects.equals(courseId, courseVO.courseId) &&
                Objects.equals(teacherId, courseVO.teacherId) &&
                Objects.equals(roomId, courseVO.roomId) &&
                Objects.equals(classId, courseVO.classId) &&
                Objects.equals(usageStatusFlag, courseVO.usageStatusFlag);
    }

    //
// 数据库字段
// ------------------------------------------------------------------------------
    private Long courseId;
    private Long courseNum;
    private Integer courseQuantity;
    private String courseName;
    private Long teacherId;
    private Long roomId;
    private Long classId;
    private Integer usageStatusFlag;
    private Integer sortStatusFlag;
    private String major;
    private String teacherName;
    private String roomNum;
    private String className;



//
// 非数据库字段
// ------------------------------------------------------------------------------

//
// getter/setter
// ------------------------------------------------------------------------------

}
