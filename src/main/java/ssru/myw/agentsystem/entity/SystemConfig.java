package ssru.myw.agentsystem.entity;
/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class SystemConfig extends Base {
    /**
     * CREATE TABLE `as_systemconfig` (
     * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
     * `configType` int(11) NOT NULL,
     * `configTypeName` varchar(20) NOT NULL,
     * `configTypeValue` int(11) NOT NULL,
     * `configValue` varchar(200) DEFAULT NULL,
     * `isStart` int(11) NOT NULL DEFAULT '1',
     * PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
     */
    /** 一级编号 */
    private Integer configType;
    /** 配置项名称 */
    private String configTypeName;
    /** 二级编号 */
    private Integer configTypeValue;
    /** 配置项的值 */
    private String configValue;
    /** 标记 */
    private Integer isStart;

    public SystemConfig() {
        super();
    }


    public SystemConfig(Integer configType, String configTypeName,
            Integer configTypeValue, String configValue, Integer isStart) {
        super();
        this.configType = configType;
        this.configTypeName = configTypeName;
        this.configTypeValue = configTypeValue;
        this.configValue = configValue;
        this.isStart = isStart;
    }


    public Integer getConfigType() {
        return configType;
    }

    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

    public String getConfigTypeName() {
        return configTypeName;
    }

    public void setConfigTypeName(String configTypeName) {
        this.configTypeName = configTypeName;
    }

    public Integer getConfigTypeValue() {
        return configTypeValue;
    }

    public void setConfigTypeValue(Integer configTypeValue) {
        this.configTypeValue = configTypeValue;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    @Override
    public String toString() {
        return super.toString() + "SystemConfig [configType=" + configType + ", configTypeName="
                + configTypeName + ", configTypeValue=" + configTypeValue
                + ", configValue=" + configValue + ", isStart=" + isStart + "]";
    }


}
