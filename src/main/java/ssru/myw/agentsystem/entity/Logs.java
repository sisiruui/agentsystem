package ssru.myw.agentsystem.entity;

import java.util.Date;
/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class Logs extends Base {
    /** 用户id */
    private Integer userId;
    /** 用户名称 */
    private String userName;
    /** 用户信息 */
    private String operateInfo;
    /** 时间 */
    private Date operateDatetime;
    /**  */
    private String odt;


    public Logs(Integer userId, String userName, String operateInfo,
            Date operateDatetime) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.operateInfo = operateInfo;
        this.operateDatetime = operateDatetime;
    }

    public Logs() {
        super();
    }


    public String getOdt() {
        return odt;
    }

    public void setOdt(String odt) {
        this.odt = odt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperateInfo() {
        return operateInfo;
    }

    public void setOperateInfo(String operateInfo) {
        this.operateInfo = operateInfo;
    }

    public Date getOperateDatetime() {
        return operateDatetime;
    }

    public void setOperateDatetime(Date operateDatetime) {
        this.operateDatetime = operateDatetime;
    }


}
