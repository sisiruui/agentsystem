package ssru.myw.agentsystem.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * @date:
 * @date: 2018/11/03
 */
public class Customs extends Base {
    /**
     * 代理商id
     */
    private Integer agentId;
    /**
     * 代理商的名称
     */
    private String agentName;
    /**
     * 代理商的编码
     */
    private String agentCode;
    /**
     * 企业名称
     */
    private String customName;
    /**
     * 企业类型 值
     */
    private Integer customType;
    /**
     * 企业类型名称
     */
    private String customTypeName;
    /**
     * 企业主页
     */
    private String siteUrl;
    /**
     * 状态
     */
    private Integer customStatus;
    /**
     * 法人
     */
    private String bossName;
    /**
     * 证件类型
     */
    private Integer cardType;
    /**
     * 证件类型值
     */
    private String cardTypeName;
    /**
     * 证件号码
     */
    private String cardNum;
    /**
     * 电话
     */
    private String companyTel;
    /**
     * 传真
     */
    private String companyFax;
    /**
     * 时间
     */
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date regDatetime;
    /**
     * 国家
     */
    private String country;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 地址
     */
    private String companyAddress;
    /**
     * 备注
     */
    private String memo;

    private List<Contacts> list;

    @Override
    public String toString() {
        return "Customs{" +
                "agentId=" + agentId +
                ", agentName='" + agentName + '\'' +
                ", agentCode='" + agentCode + '\'' +
                ", customName='" + customName + '\'' +
                ", customType=" + customType +
                ", customTypeName='" + customTypeName + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", customStatus=" + customStatus +
                ", bossName='" + bossName + '\'' +
                ", cardType=" + cardType +
                ", cardTypeName='" + cardTypeName + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", companyTel='" + companyTel + '\'' +
                ", companyFax='" + companyFax + '\'' +
                ", regDatetime=" + regDatetime +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", memo='" + memo + '\'' +
                '}';
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

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Integer getCustomType() {
        return customType;
    }

    public void setCustomType(Integer customType) {
        this.customType = customType;
    }

    public String getCustomTypeName() {
        return customTypeName;
    }

    public void setCustomTypeName(String customTypeName) {
        this.customTypeName = customTypeName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public Integer getCustomStatus() {
        return customStatus;
    }

    public void setCustomStatus(Integer customStatus) {
        this.customStatus = customStatus;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public Date getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(Date regDatetime) {
        this.regDatetime = regDatetime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<Contacts> getList() {
        return list;
    }

    public void setList(List<Contacts> list) {
        this.list = list;
    }


}