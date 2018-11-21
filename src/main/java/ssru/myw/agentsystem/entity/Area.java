package ssru.myw.agentsystem.entity;

/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class Area extends Base{
    /**
     * CREATE TABLE `hat_area` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `areaID` varchar(50) DEFAULT NULL,
     `area` varchar(60) DEFAULT NULL,
     `father` varchar(6) DEFAULT NULL,
     PRIMARY KEY (`id`)
     ) ENGINE=MyISAM AUTO_INCREMENT=3145 DEFAULT CHARSET=utf8;
     */
    /** 地区名称 */
    private String areaId;
    /** 地区的id */
    private String area;
    /** 地区所属的省 */
    private String father;

    public Area() {
    }


    @Override
    public String toString() {
        return "Area{" +
                "areaId='" + areaId + '\'' +
                ", area='" + area + '\'' +
                ", father='" + father + '\'' +
                ", id=" + id +
                '}';
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }
}