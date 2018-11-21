package ssru.myw.agentsystem.util;

import ssru.myw.agentsystem.doye.Memento;
import ssru.myw.agentsystem.util.memonto.PageNumberMemento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/16
 */
public class PageNumber {
    /**  1 2 3 4 5 6 如果当前页是第3页，则前置集合是1，2 */
    private List<Integer> prevList = new ArrayList<Integer>();
    /**  1 2 3 4 5 6 如果当前页是第3页，则后置集合是4，5，6*/
    private List<Integer> nextList = new ArrayList<Integer>();
    /** 请求的页码 -需要传入*/
    private Integer thePage;//当前页
    /** 总记录数 - 需要传入 */
    private Integer totalCount;//总记录数
    /** 总页数  */
    private Integer pageCount;//总页数
    /** 每页的信息数 本类默认为10，不可修改。因为修改后的逻辑未加入 待加入 */
    private Integer pageSize = 10;
    /** 前页后页都能使用的数量   如 当前页是5，则num为1的时候，结果是456，如果为2，则结果是34567  */
    private Integer num=5;  //当前页前与页后都能显示3页

    public PageNumber() {
    }

    public PageNumber(Integer thePage, Integer totalCount) {
        // 外部数据
        this.thePage = thePage;
        this.totalCount = totalCount;
        if (totalCount > 0) {
            // 设置总页码
            this.pageCount = totalCount%pageSize==0? totalCount/pageSize:totalCount/pageSize+1;
            if (this.pageCount <= 11) {//如果小于12页就不用执行那么多的逻辑了
                pageCountLess(); // 总页数少
            } else {
                // 判断当前页小于6吗
                if (this.thePage < 6) { //这是总页数大，当前页小。
                    thePageNumberSamll();
                } else if (this.thePage > this.pageCount - 5){
                    thePageNumberLarge();
                } else {
                    this.thePageNumberDefault();
                }



            }






        }


    }

    /**
     * 总页数如果小于11 就全都显示
     */
    private void pageCountLess() {
        // 如果thepage为1，则没有，如果为2，集合为1 如果为6 集合为12345
        for (int i = 1; i < this.thePage ; i++) {
            prevList.add(i);
        }
        //如果thepage 为1 集合为23456 ，为2 集合是3456， 为6 没有
        for (int i = this.thePage+1; i <= this.pageCount; i++) {
            nextList.add(i);
        }
    }

    private void thePageNumberSamll() {
        // 如果thepage为1，则没有，如果为2，集合为1 如果为6 集合为12345
        for (int i = 1; i < this.thePage ; i++) {
            prevList.add(i);
        }
        //如果thepage 为1 集合为23456 ，为2 集合是3456， 为6 没有
        for (int i = this.thePage+1; i <= 11; i++) {
            nextList.add(i);
        }
    }
    private void thePageNumberLarge() {
        // 如果thepage为1，则没有，如果为2，集合为1 如果为6 集合为12345
        for (int i = this.pageCount - 10; i < this.thePage ; i++) {
            prevList.add(i);
        }
        //如果thepage 为1 集合为23456 ，为2 集合是3456， 为6 没有
        for (int i = this.thePage+1; i <= this.pageCount; i++) {
            nextList.add(i);
        }
    }
    private void thePageNumberDefault() {
        // 如果thepage为1，则没有，如果为2，集合为1 如果为6 集合为12345
        for (int i = this.thePage - 5; i < this.thePage ; i++) {
            prevList.add(i);
        }
        //如果thepage 为1 集合为23456 ，为2 集合是3456， 为6 没有
        for (int i = this.thePage+1; i <= this.thePage + 5; i++) {
            nextList.add(i);
        }
    }


    /**
     * 得到前置 数字   出口方法
     * @return
     */
    public List<Integer> getPrevList() {
        return prevList;
    }
    /**
     * 得到后置数字 出口方法
     * @return
     */
    public List<Integer> getNextList() {
        return nextList;
    }

    @Override
    public String toString() {
        return "PageNumber{" +
                "prevList=" + prevList +
                ", nextList=" + nextList +
                ", thePage=" + thePage +
                ", totalCount=" + totalCount +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", num=" + num +
                '}';
    }

    public PageNumberMemento createMemento(){
        PageNumberMemento pageNumberMemento = new PageNumberMemento();
        pageNumberMemento.setNextList(nextList);
        pageNumberMemento.setPrevList(prevList);

        return pageNumberMemento;
    }
    public void setMemento(PageNumberMemento pageNumberMemento){
        this.nextList= pageNumberMemento.getNextList();
        this.prevList = pageNumberMemento.getPrevList();

    }

}
