package ssru.myw.agentsystem.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.DigestUtils;
import ssru.myw.agentsystem.message.JsonMessage;

import java.nio.charset.Charset;

/**
 * @ Author     ：mayiwen.
 * @ Date       ：Created in 14:35 2018/11/3
 */
public class StringUtil {
    private StringUtil() {
    }
    public static StringUtil stringUtil = new StringUtil();
    public static StringUtil getInstance() {
        if (stringUtil == null) {
            synchronized (StringUtil.class) {
                if (stringUtil == null) {
                    stringUtil = new StringUtil();
                }
            }
        }
        return stringUtil;
    }

    /**
     * 自负串转md5
     * @param str
     * @return
     */
    public String md5(String str) {

        return DigestUtils.md5DigestAsHex(str.getBytes(Charset.forName("UTF-8")));
    }

    /**
     *
     * @param mybatisReturn
     * @param o
     * @return
     * 如果Object 对象不存在成功返回 success 的字符。
     * 如果Object 对象存在，则返回o的json数据。
     *  异常返回 exception 的字符串。
     *  失败返回 failure 的字符串。
     *
     *
     */
    public String mybatisReturnMessage(int mybatisReturn, Object o) {
        String message = "";
        if (mybatisReturn == 0) { // 失败返回message
            message = JsonMessage.FAILURE.toString().toLowerCase();
        } else if (mybatisReturn == -1) { // 异常返回的信息。
            message = JsonMessage.EXCEPTION.toString().toLowerCase();
        }else { //成功返回的信息。
            if (ObjectEmpty.getInstance().isNullOrEmpty(o)) {
                message = JsonMessage.SUCCESS.toString().toLowerCase();
            } else {
                message = JSON.toJSONString(o);
            }
        }
        return message;
    }

    public String getMissing() {
        return JsonMessage.MISSING.toString().toLowerCase();
    }






}
