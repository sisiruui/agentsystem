package ssru.myw.agentsystem.entity;
/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class Contacts extends Base{
    /**
     * CREATE TABLE `as_contacts` (
     `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
     `customId` bigint(20) NOT NULL,
     `contactName` varchar(20) DEFAULT NULL,
     `contactTel` varchar(20) DEFAULT NULL,
     `contactFax` varchar(20) DEFAULT NULL,
     `contactEmail` varchar(20) DEFAULT NULL,
     `contactRole` varchar(20) DEFAULT NULL,
     PRIMARY KEY (`id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
     */
    /** 代理商id */
    private Long customId;
    /** 用户姓名 */
    private String contactName;
    /** 用户电话 */
    private String contactTel;
    /** 用户传真 */
    private String contactFax;
    /** 用户邮箱 */
    private String contactEmail;
    /** 用户的职务， 这个是用户自填的职务，与业务逻辑无关，仅仅是个用户设定的职务。这个可以随意设置 */
    private String contactRole;


    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactFax() {
        return contactFax;
    }

    public void setContactFax(String contactFax) {
        this.contactFax = contactFax;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactRole() {
        return contactRole;
    }

    public void setContactRole(String contactRole) {
        this.contactRole = contactRole;
    }
}