package top.kwrcee.sortcourse.manage.entities;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@VersionAudit
@ModifyAudit
@Table(name = "sys_user")
public class SysUser extends AuditDomain implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户角色
     */
    @Transient
    private List<SysRole> roleList;
    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
