package ssru.myw.agentsystem.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class AccountDetail extends Base{


    /** user id  */
    private Integer userId;
    /** 类型 as_systemconfig  表的 configtype = 1  的 configTypeName */
    private Integer detailType;
    /** 类型名称 as_systemconfig  表的 configtype = 1  的 configTypeValue */
    private String detailTypeName;
    /** 服务资金 */
    private BigDecimal money;
    /** 账户的余额 */
    private BigDecimal accountMoney;
    /** 备注信息 */
    private String memo;
    /** 交易明细时间 */
    private Timestamp detailDateTime;
    private String userName;
    private  User user;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDetailType() {
        return detailType;
    }

    public void setDetailType(Integer detailType) {
        this.detailType = detailType;
    }

    public String getDetailTypeName() {
        return detailTypeName;
    }

    public void setDetailTypeName(String detailTypeName) {
        this.detailTypeName = detailTypeName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(BigDecimal accountMoney) {
        this.accountMoney = accountMoney;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Timestamp getDetailDateTime() {
        return detailDateTime;
    }

    public void setDetailDateTime(Timestamp detailDateTime) {
        this.detailDateTime = detailDateTime;
    }

    @Override
    public String toString() {
        return "AccountDetail{" +
                "userId=" + userId +
                ", detailType=" + detailType +
                ", detailTypeName='" + detailTypeName + '\'' +
                ", money=" + money +
                ", accountMoney=" + accountMoney +
                ", memo='" + memo + '\'' +
                ", detailDateTime=" + detailDateTime +
                ", userName='" + userName + '\'' +
                ", user=" + user +
                '}';
    }
}