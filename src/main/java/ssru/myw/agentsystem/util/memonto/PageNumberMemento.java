package ssru.myw.agentsystem.util.memonto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/17
 */
public class PageNumberMemento {
    /**  1 2 3 4 5 6 如果当前页是第3页，则前置集合是1，2 */
    private List<Integer> prevList = new ArrayList<Integer>();
    /**  1 2 3 4 5 6 如果当前页是第3页，则后置集合是4，5，6*/
    private List<Integer> nextList = new ArrayList<Integer>();

    public List<Integer> getPrevList() {
        return prevList;
    }

    public void setPrevList(List<Integer> prevList) {
        this.prevList = prevList;
    }

    public List<Integer> getNextList() {
        return nextList;
    }

    public void setNextList(List<Integer> nextList) {
        this.nextList = nextList;
    }
}
