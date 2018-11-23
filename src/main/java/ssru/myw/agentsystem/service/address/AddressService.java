package ssru.myw.agentsystem.service.address;

import ssru.myw.agentsystem.entity.City;
import ssru.myw.agentsystem.entity.Province;

import java.util.List;

public interface AddressService {
    List<Province> listProvince();

    List<City> listCity(Province province);

    List<City> listArea(City city);
}
