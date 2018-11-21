package ssru.myw.agentsystem.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class Role extends Base {
    /*
     * CREATE TABLE `as_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色主键ID',
  `roleName` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名称',
  `creationTime` datetime NOT NULL COMMENT '创建时间',
  `createdBy` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '创建者',
  `lastUpdateTime` datetime DEFAULT '2013-01-01 00:00:01' COMMENT '最后修改时间',
  `isStart` int(11) DEFAULT '1' COMMENT '是否启用1为启用0为不启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
     */
    /** 角色名称 */
    private String roleName;
    /** 创建的事件 */
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date creationTime;
    /** 创建人 */
    private String createdBy;
    /** 最后登陆的事件 */
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date lastUpdateTime;
    /** 是否	启用     这个可以控制 */
    private Integer isStart;

    public Role() {
        super();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    @Override
    public String toString() {
        return "Role [roleName=" + roleName + ", creationTime=" + creationTime
                + ", createdBy=" + createdBy + ", lastUpdateTime="
                + lastUpdateTime + ", isStart=" + isStart + "]";
    }


}
