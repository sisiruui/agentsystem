package ssru.myw.agentsystem.dao;

import ssru.myw.agentsystem.entity.SystemConfig;
import ssru.myw.agentsystem.entity.User;

import java.util.List;

public interface SystemConfigMapper {

    /**
     * 获取列表
     *
     * @param sc
     * @return
     */
    List<SystemConfig> listSystemConfig(SystemConfig sc);


    /**
     * 获取最大的 ConfigTypeValue + 1 就是新插入的ConfigTypeValue值，这个使用的时候要转String
     *
     * @param configType
     * @return
     */
    Integer getMaxConfigTypeValue(Integer configType);

    /**
     * 这是添加添加的方法，返回的是int插入结果，而且执行了，添加id的操作。
     *
     * @param systemConfig
     * @return
     */
    Integer saveSystemConfig(SystemConfig systemConfig);

    /**
     * 删除的方法通过id删除
     * @param systemConfig
     * @return
     */
    Integer deleteSystemConfig(SystemConfig systemConfig);

    int updateSystemConfig(SystemConfig systemConfig);
}
