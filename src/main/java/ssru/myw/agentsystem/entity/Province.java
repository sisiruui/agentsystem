package ssru.myw.agentsystem.entity;
/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class Province extends Base {
    /**
     * CREATE TABLE `hat_province` (
     * `id` int(11) NOT NULL AUTO_INCREMENT,
     * `provinceID` varchar(6) DEFAULT NULL,
     * `province` varchar(40) DEFAULT NULL,
     * PRIMARY KEY (`id`)
     * ) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
     */
    private String provinceID;
    private String province;


    /**
     * 通过省id 查省
     *
     * @param provinceID
     */
    public Province(String provinceID) {
        super();
        this.provinceID = provinceID;
    }

    public Province() {
        super();
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Province(String provinceID, String province) {
        super();
        this.provinceID = provinceID;
        this.province = province;
    }

    @Override
    public String toString() {
        return "Provice [provinceID=" + provinceID + ", province=" + province
                + "]";
    }


}
