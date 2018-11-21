package ssru.myw.agentsystem.service.customs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.CustomsMapper;
import ssru.myw.agentsystem.entity.Customs;
import ssru.myw.agentsystem.util.PageNumber;
import ssru.myw.agentsystem.util.memonto.PageNumberCareTaker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/21
 */
@Service("customsService")
@Transactional(readOnly=true)
public class CustomsServiceImpl implements CustomsService{
    @Autowired
    private CustomsMapper customsMapper;

    @Override
    public List<Customs> listCustoms(Customs customs, PageNumberCareTaker pageNumberCareTaker) {
        List<Customs> list = new ArrayList<>();
        int pageNum = (customs.getThePage() - 1) * 10;
        customs.setPageStartNum(pageNum);
        customs.setPageSize(10);
        list = customsMapper.listCustoms(customs);
        Integer totalCount = customsMapper.countCustoms(customs);
        PageNumber pageNumber = new PageNumber(customs.getThePage(),totalCount );
        pageNumberCareTaker.setMemento(pageNumber.createMemento());

        return customsMapper.listCustoms(customs);
    }
}
