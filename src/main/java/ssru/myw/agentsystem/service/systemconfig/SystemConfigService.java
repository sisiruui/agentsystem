package ssru.myw.agentsystem.service.systemconfig;

import ssru.myw.agentsystem.entity.SystemConfig;

import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/6
 */
public interface SystemConfigService {

    List<SystemConfig> listSystemConfig(SystemConfig sc);

    Integer saveSystemConfig(SystemConfig systemConfig);

    int deleteSystemConfig(SystemConfig systemConfig);

    int updateSystemConfig(SystemConfig systemConfig);
}
