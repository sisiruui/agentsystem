package ssru.myw.agentsystem.entity;

import ssru.myw.agentsystem.entity.Base;
import ssru.myw.agentsystem.entity.Contacts;
import ssru.myw.agentsystem.entity.Customs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class Keywords extends Base {
    /**
     * CREATE TABLE `as_keywords` (
     * `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
     * `keywords` VARCHAR(100) NOT NULL,
     * `agentId` BIGINT(20) NOT NULL,
     * `agentName` VARCHAR(255) NOT NULL,
     * `customId` BIGINT(20) NOT NULL,
     * `customName` VARCHAR(255) NOT NULL,
     * `preRegFrozenMoney` DOUBLE NOT NULL DEFAULT '0',
     * `price` DOUBLE NOT NULL DEFAULT '0',
     * `productType` INT(11) DEFAULT '0',
     * `serviceYears` INT(11) DEFAULT '0' COMMENT '服务年限',
     * `openApp` INT(11) DEFAULT '0' COMMENT '0未开通 1 开通',
     * `appUserName` VARCHAR(64) DEFAULT NULL,
     * `appPassword` VARCHAR(70) DEFAULT NULL,
     * `loginUrl` VARCHAR(255) DEFAULT NULL COMMENT '登陆地址',
     * `iosDownloadUrl` VARCHAR(255) DEFAULT NULL COMMENT 'ios客户端下载地址',
     * `androidDownloadUrl` VARCHAR(255) DEFAULT NULL COMMENT 'android客户端下载地址',
     * `codeIosUrl` VARCHAR(255) DEFAULT NULL COMMENT 'IOS二维码下载地址',
     * `codeAndroidUrl` VARCHAR(255) DEFAULT NULL COMMENT 'android二维码下载地址',
     * `preRegDatetime` DATETIME DEFAULT '2012-01-01 00:01:01',
     * `preRegPassDatetime` DATETIME DEFAULT '2012-01-01 00:01:01',
     * `regDatetime` DATETIME DEFAULT '2012-01-01 00:01:01',
     * `regPassDatetime` DATETIME DEFAULT '2012-01-01 00:01:01',
     * `isPass` INT(11) DEFAULT '0' COMMENT '0为不过期，1为预注册过期，2为 注册过期',
     * `checkStatus` INT(11) DEFAULT '0' COMMENT '0为已申请 1为审核中 2为    ['已通过 3未通过',
     * `isUse` INT(11) DEFAULT '0' COMMENT '1为已使用 0为未使用',
     * PRIMARY KEY (`id`)
     * ) ENGINE=INNODB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
     */
    /** 关键词 */
    private String keywords;
    /**  */
    private Integer agentId;
    /** 代理商姓名 */
    private String agentName;
    /** 用户id */
    private Integer customId;
    /** 用户姓名 */
    private String customName;
    /**  */
    private BigDecimal preRegFrozenMoney;
    /**  */
    private BigDecimal price;
    /** 产品类型 */
    private Integer productType;
    /** //服务年限 */
    private Integer serviceYears;
    /** 0未开通 1 开通 */
    private Integer openApp;
    /**  */
    private String appUserName;
    /**  */
    private String appPassword;
    /** 登陆地址 */
    private String loginUrl;
    /** ios客户端下载地址 */
    private String iosDownloadUrl;
    /** android客户端下载地址 */
    private String androidDownloadUrl;
    /** IOS二维码下载地址 */
    private String codeIosUrl;
    /** android二维码下载地址 */
    private String codeAndroidUrl;
    /** 申请时间 */
    private Date preRegDatetime;
    /** 第一次申请的结束时间 */
    private Date preRegPassDatetime;
    /** 申请时间 */
    private Date regDatetime;
    /** 申请截止的时间 */
    private Date regPassDatetime;
    /** 0为不过期，1为预注册过期，2为正式注册过期 */
    private Integer isPass;
    /** '0为已申请 1为审核中 2为已通过 3未通过 */
    private Integer checkStatus;
    /** 1为已使用 0为未使用 */
    private Integer isUse;



    private Customs customs;
    private List<Contacts> contactsList;


    public Customs getCustoms() {
        return customs;
    }


    public void setCustoms(Customs customs) {
        this.customs = customs;
    }


    public List<Contacts> getContactsList() {
        return contactsList;
    }


    public void setContactsList(List<Contacts> contactsList) {
        this.contactsList = contactsList;
    }


    public Keywords() {
        super();
    }


    public String getKeywords() {
        return keywords;
    }


    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getCustomId() {
        return customId;
    }

    public void setCustomId(Integer customId) {
        this.customId = customId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public BigDecimal getPreRegFrozenMoney() {
        return preRegFrozenMoney;
    }

    public void setPreRegFrozenMoney(BigDecimal preRegFrozenMoney) {
        this.preRegFrozenMoney = preRegFrozenMoney;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getServiceYears() {
        return serviceYears;
    }

    public void setServiceYears(Integer serviceYears) {
        this.serviceYears = serviceYears;
    }

    public Integer getOpenApp() {
        return openApp;
    }

    public void setOpenApp(Integer openApp) {
        this.openApp = openApp;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getAppPassword() {
        return appPassword;
    }

    public void setAppPassword(String appPassword) {
        this.appPassword = appPassword;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getIosDownloadUrl() {
        return iosDownloadUrl;
    }

    public void setIosDownloadUrl(String iosDownloadUrl) {
        this.iosDownloadUrl = iosDownloadUrl;
    }

    public String getAndroidDownloadUrl() {
        return androidDownloadUrl;
    }

    public void setAndroidDownloadUrl(String androidDownloadUrl) {
        this.androidDownloadUrl = androidDownloadUrl;
    }

    public String getCodeIosUrl() {
        return codeIosUrl;
    }

    public void setCodeIosUrl(String codeIosUrl) {
        this.codeIosUrl = codeIosUrl;
    }

    public String getCodeAndroidUrl() {
        return codeAndroidUrl;
    }

    public void setCodeAndroidUrl(String codeAndroidUrl) {
        this.codeAndroidUrl = codeAndroidUrl;
    }

    public Date getPreRegDatetime() {
        return preRegDatetime;
    }

    public void setPreRegDatetime(Date preRegDatetime) {
        this.preRegDatetime = preRegDatetime;
    }

    public Date getPreRegPassDatetime() {
        return preRegPassDatetime;
    }

    public void setPreRegPassDatetime(Date preRegPassDatetime) {
        this.preRegPassDatetime = preRegPassDatetime;
    }

    public Date getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(Date regDatetime) {
        this.regDatetime = regDatetime;
    }

    public Date getRegPassDatetime() {
        return regPassDatetime;
    }

    public void setRegPassDatetime(Date regPassDatetime) {
        this.regPassDatetime = regPassDatetime;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "Keywords [keywords=" + keywords + ", agentId=" + agentId + ", agentName=" + agentName + ", customId="
                + customId + ", customName=" + customName + ", preRegFrozenMoney=" + preRegFrozenMoney + ", price="
                + price + ", productType=" + productType + ", serviceYears=" + serviceYears + ", openApp=" + openApp
                + ", appUserName=" + appUserName + ", appPassword=" + appPassword + ", loginUrl=" + loginUrl
                + ", iosDownloadUrl=" + iosDownloadUrl + ", androidDownloadUrl=" + androidDownloadUrl + ", codeIosUrl="
                + codeIosUrl + ", codeAndroidUrl=" + codeAndroidUrl + ", preRegDatetime=" + preRegDatetime
                + ", preRegPassDatetime=" + preRegPassDatetime + ", regDatetime=" + regDatetime + ", regPassDatetime="
                + regPassDatetime + ", isPass=" + isPass + ", checkStatus=" + checkStatus + ", isUse=" + isUse + "]";
    }


}
