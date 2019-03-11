package top.kwrcee.sortcourse.manage.entities;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;

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
@Table(name = "classroom")
public class Room extends AuditDomain {
    public static final String FIELD_ROOM_ID = "roomId";
    public static final String FIELD_ROOM_NAME = "roomName";
    public static final String FIELD_ROOM_NUM = "roomNum";
    public static final String FIELD_LOCATION = "location";
    public static final String FIELD_FLOOR = "floor";
    public static final String FIELD_USAGE_STATUS_FLAG = "usageStatusFlag";
    public static final String FIELD_MANAGER = "manager";
    public static final String FIELD_REMARK = "remark";

//
// 业务方法(按public protected private顺序排列)
// ------------------------------------------------------------------------------

//
// 数据库字段
// ------------------------------------------------------------------------------
    @Id
    @GeneratedValue
    private Long roomId;
    private String roomName;
    private String roomNum;
    private String location;
    private String floor;
    private Integer usageStatusFlag;
    private String manager;
    private String remark;

//
// 非数据库字段
// ------------------------------------------------------------------------------

//
// getter/setter
// ------------------------------------------------------------------------------


    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", location='" + location + '\'' +
                ", floor='" + floor + '\'' +
                ", usageStatusFlag=" + usageStatusFlag +
                ", manager='" + manager + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getUsageStatusFlag() {
        return usageStatusFlag;
    }

    public void setUsageStatusFlag(Integer usageStatusFlag) {
        this.usageStatusFlag = usageStatusFlag;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
