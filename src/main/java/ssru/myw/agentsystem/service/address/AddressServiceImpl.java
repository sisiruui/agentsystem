package ssru.myw.agentsystem.service.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.AddressMapper;
import ssru.myw.agentsystem.entity.City;
import ssru.myw.agentsystem.entity.Province;

import java.util.List;

@Service("addressService")
@Transactional(readOnly=true)
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Province> listProvince() {
        return addressMapper.listProvince();
    }

    @Override
    public List<City> listCity(Province province) {
        return addressMapper.listCity(province);
    }

    @Override
    public List<City> listArea(City city) {
        return addressMapper.listArea(city);
    }
}
