package ssru.myw.agentsystem.dao;

import ssru.myw.agentsystem.entity.Area;
import ssru.myw.agentsystem.entity.City;
import ssru.myw.agentsystem.entity.Province;

import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/22
 */
public interface AddressMapper {


    List<Province> listProvince();

    List<City> listCity(Province province);

    List<City> listArea(City city);

    Province getProvince(String provinceID);

    City getCity(String cityID);

    Area getArea(String areaID);
}
