package ssru.myw.agentsystem.util;

import java.util.Collection;
import java.util.Map;

/**
 * @ Author     ：mayiwen.
 * @ Date       ：Created in 17:08 2018/11/2
 * 单例 singleton
 * 这是操作对象是否为空的工具类
 *
 */
public class ObjectEmpty {
    private static volatile ObjectEmpty objectEmpty = new ObjectEmpty();
    private ObjectEmpty() {}

    public static ObjectEmpty getInstance() {
        if (objectEmpty == null) {
            synchronized (ObjectEmpty.class) {
                if (objectEmpty == null) {
                    objectEmpty = new ObjectEmpty();
                }
            }
        }
        return objectEmpty;
    }

    /**
     *
     * 这是判断对象是否为空的方法。
     * 使用：    ObjectEmpty.getInstance().isNullOrEmpty( 要判断的对象，Object )
     * @param obj 要判断的对象
     * @return 为空返回true，否则返回false。
     */
    public boolean isNullOrEmpty(Object obj) {
        if (obj == null)
            return true;

        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isNullOrEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }










}
