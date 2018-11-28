package ssru.myw.agentsystem.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ssru.myw.agentsystem.entity.Area;
import ssru.myw.agentsystem.entity.City;
import ssru.myw.agentsystem.entity.Province;
import ssru.myw.agentsystem.service.address.AddressService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/22
 */
@RestController
@RequestMapping("/address")

public class AddressController {
    @Autowired
    private AddressService addressService;




    /**
     * 获取所有的省份列表
     * @return
     */

    @GetMapping("/province")
    public String listProvince() {
        List<Province> list = new ArrayList<>();
        list = addressService.listProvince();
        return JSON.toJSONString(list);
    }

    /**
     * 根据province 来查该省下所有的市
     * @param province
     * @return
     */
    @GetMapping("/city")
    public String listCity(Province province) {
        List<City> list = new ArrayList<>();
        list = addressService.listCity(province);
        return JSON.toJSONString(list);
    }
    @GetMapping("/area")
    public String listArea(City city) {
        List<City> list = new ArrayList<>();
        list = addressService.listArea(city);
        return JSON.toJSONString(list);
    }
    @GetMapping("/province/provinceID")
    public String getProvince(String provinceID) {
        Province province = new Province();
        province = addressService.getProvince(provinceID);

        return JSON.toJSONString(province);
    }
    @GetMapping("/city/cityID")
    public String getCity(String cityID) {
        City city = new City();
        city = addressService.getCity(cityID);

        return JSON.toJSONString(city);
    }
    @GetMapping("/area/areaID")
    public String getArea(String areaID) {
        Area area = new Area();
        area = addressService.getArea(areaID);

        return JSON.toJSONString(area);
    }

}
