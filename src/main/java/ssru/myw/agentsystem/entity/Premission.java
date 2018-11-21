package ssru.myw.agentsystem.entity;

import java.util.Date;
/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class Premission extends Base {
    /*
     *
    CREATE TABLE `as_role_premission` (
      `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
      `roleId` bigint(20) NOT NULL COMMENT '角色ID',
      `functionId` bigint(20) NOT NULL COMMENT '功能ID',
      `creationTime` datetime NOT NULL COMMENT '创建时间',
      `createdBy` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '创建者',
      `lastUpdateTime` datetime DEFAULT '2013-01-01 00:00:01' COMMENT '最后修改时间',
      `isStart` int(11) DEFAULT '1' COMMENT '1为启用0为不启用',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
     */
    /** 角色id */
    private Integer roleId;
    /** 功能id */
    private Integer functionId;
    /** 创建时间 */
    private Date creationTime;
    /** 创建人 */
    private String createdBy;
    /** 最后修改时间 */
    private Date lastUpdateTime;
    /** 是否启用 */
    private Integer isStart;

    public Premission() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }


}
