package ssru.myw.agentsystem.service.systemconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.SystemConfigMapper;
import ssru.myw.agentsystem.entity.SystemConfig;
import ssru.myw.agentsystem.util.ObjectEmpty;

import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/6
 */

@Service("systemConfigService")
@Transactional(readOnly=true)
public class SystemConfigServiceImpl implements SystemConfigService {


    @Autowired
    private SystemConfigMapper systemConfigMapper;

    @Override
    public List<SystemConfig> listSystemConfig(SystemConfig sc) {
        return systemConfigMapper.listSystemConfig(sc);
    }
    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    public Integer saveSystemConfig(SystemConfig systemConfig) {
        // 根据configtype 获取 configtypevalue的植，它是同configtype最大的configtypevalue的植+1;
//        systemConfig.setConfigValue(systemConfigMapper.getMaxConfigTypeValue(systemConfig.getConfigType())+"");
//        if (ObjectEmpty.getInstance().isNullOrEmpty(systemConfig.getConfigTypeValue())) {
//            systemConfig.getConfigTypeValue("(NULL)");
//        }
        // 通过 getConfigType 得到自栽跟头的setConfigTypeValue
        if (systemConfig.getConfigType() != 7) {
            systemConfig.setConfigTypeValue(systemConfigMapper.getMaxConfigTypeValue(systemConfig.getConfigType()));

        }
        if (ObjectEmpty.getInstance().isNullOrEmpty(systemConfig.getConfigValue())) {
        systemConfig.setConfigValue("(NULL)");
        }



        return    systemConfigMapper.saveSystemConfig(systemConfig);


    }


//    public Integer getMaxConfigTypeValue(Integer configType)  {
//        return systemConfigMapper.getMaxConfigTypeValue(configType);
//
//
//    }


    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    public int deleteSystemConfig(SystemConfig systemConfig) {
        return systemConfigMapper.deleteSystemConfig(systemConfig);
    }

    @Override

    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)

    public int updateSystemConfig(SystemConfig systemConfig) {
        return systemConfigMapper.updateSystemConfig(systemConfig);
    }
}
