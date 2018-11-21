

import ssru.myw.agentsystem.util.StringUtil;

/**
 * @author: mayiwen
 * @date: 2018/11/6
 */
public class Test {
    public static void main(String[] args) {
        String s = "123456";
        String md5 = StringUtil.getInstance().md5(s);
        System.out.println(md5);
    }
}
