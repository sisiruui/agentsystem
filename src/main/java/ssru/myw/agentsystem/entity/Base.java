package ssru.myw.agentsystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @ Author     ：mayiwen.
 * @ Date       ：Created in 15:50 2018/11/2
 */
public class Base implements Serializable {
    /** 这是所有的id */
    protected Integer id;
    /** 这是创建的时间 */
    protected Timestamp gmtCreate;
    /** 这是修改的时间 */
    protected Timestamp gmtModified;

//    查询辅助属性。

    /** 分页的开始 */
    protected Integer pageStartNum;
    /** 页面的大小 */
    protected Integer pageSize;

    protected Integer thePage;

    /** 日期查询开始的时间 */
    protected Date startTime;
    /** 日期查询结束的时间 */
    protected Date entTime;//结束时间
    /** 字符串查询盈余  */
    protected String searchStr;//查询

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getPageStartNum() {
        return pageStartNum;
    }

    public void setPageStartNum(Integer pageStartNum) {
        this.pageStartNum = pageStartNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEntTime() {
        return entTime;
    }

    public void setEntTime(Date entTime) {
        this.entTime = entTime;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public Integer getThePage() {
        return thePage;
    }

    public void setThePage(Integer thePage) {
        this.thePage = thePage;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", pageStartNum=" + pageStartNum +
                ", pageSize=" + pageSize +
                ", thePage=" + thePage +
                ", startTime=" + startTime +
                ", entTime=" + entTime +
                ", searchStr='" + searchStr + '\'' +
                '}';
    }
}
