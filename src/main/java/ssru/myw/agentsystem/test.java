package ssru.myw.agentsystem;

import com.alibaba.fastjson.JSON;
import ssru.myw.agentsystem.util.PageNumber;

import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/14
 */
public class test {
    public static void main(String[] args) {
        int thePage = 5;
        int totalCount = 100;
        PageNumber pagenunber = new PageNumber(thePage,totalCount);
        List<Integer> prevList = pagenunber.getPrevList();
        List<Integer> nextList = pagenunber.getNextList();
//        for (int i = 0; i < prevList.size(); i++) {
//            System.out.println(prevList.get(i));
//        }
//        System.out.println(thePage + "-");
//        for (int i = 0; i < nextList.size(); i++) {
//            System.out.println(nextList.get(i));
//        }

        System.out.println(JSON.toJSONString(pagenunber));

    }
}
