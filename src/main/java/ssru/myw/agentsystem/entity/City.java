package ssru.myw.agentsystem.entity;

/**
 * @author: mayiwen
 * @date: 2018/11/03
 *
 */
public class City extends Base {

    /** 城市的id */
    private String cityID;
    /** 城市的名称 */
    private String city;
    /** 上级 */
    private String father;

    @Override
    public String toString() {
        return "City{" +
                "cityID='" + cityID + '\'' +
                ", city='" + city + '\'' +
                ", father='" + father + '\'' +
                ", id=" + id +
                '}';
    }

    public String getCityID() {
        return cityID;
    }

        public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public City(String cityID, String city, String father) {
        this.cityID = cityID;
        this.city = city;
        this.father = father;
    }

    public City(String cityID) {
        this.cityID = cityID;
    }

    public City() {
    }
}