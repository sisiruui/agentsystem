package ssru.myw.agentsystem.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 */
public class User extends Base {
    public User() {
    }
    /*
     * 数据库表
     * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
      `userCode` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户CODE',
      `userName` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名称',
      `userPassword` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户登录密码',
      `creationTime` datetime NOT NULL COMMENT '注册时间',
      `lastLoginTime` datetime DEFAULT '2013-01-01 00:00:01' COMMENT '最后登录时间',
      `createdBy` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '创建者',
      `lastUpdateTime` datetime DEFAULT '2013-01-01 00:00:01' COMMENT '最后修改时间',
      `isStart` int(11) DEFAULT '1' COMMENT '是否启动1为启用0为不启用',
      `roleId` bigint(20) NOT NULL DEFAULT '0' COMMENT '所属角色',
     * */

    //用户id 继承Base
    /** 用户CODE */
    private String userCode;
    /** 用户名称 */
    private String  userName;
    /** 用户登录密码 */
    private String userPassword;
    /** 注册时间 */
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Timestamp creationTime;
    /** 最后登录时间 */
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Timestamp lastLoginTime;
    /** 创建者 */
    private String createdBy;
    /** 最后修改时间 */
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Timestamp lastUpdateTime;
    /** 这不是boolean  是否启用 */
    private Integer isStart;
    /** 所属角色id */
    private Integer roleId;
    /** 所属角色name */
    private String roleName;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return super.toString() + "User{" +
                "userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", creationTime=" + creationTime +
                ", lastLoginTime=" + lastLoginTime +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", isStart=" + isStart +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
