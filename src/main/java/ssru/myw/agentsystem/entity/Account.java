package ssru.myw.agentsystem.entity;

import java.math.BigDecimal;

/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class Account extends Base {
    /** 对应的user id */
    private Integer userId;
    /** 金额 */
    private BigDecimal money;
    /** 重复金额以保证正确 */
    private BigDecimal moneyBak;

    /** 与数据库无关的承载对象 */
    private User user;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", money=" + money +
                ", moneyBak=" + moneyBak +
                ", user=" + user +
                '}';
    }

    public BigDecimal getMoneyBak() {
        return moneyBak;
    }

    public void setMoneyBak(BigDecimal moneyBak) {
        this.moneyBak = moneyBak;
    }

}