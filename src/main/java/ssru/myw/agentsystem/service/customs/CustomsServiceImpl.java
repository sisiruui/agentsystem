package ssru.myw.agentsystem.service.customs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.ContactsMapper;
import ssru.myw.agentsystem.dao.CustomsMapper;
import ssru.myw.agentsystem.entity.Contacts;
import ssru.myw.agentsystem.entity.Customs;
import ssru.myw.agentsystem.util.ObjectEmpty;
import ssru.myw.agentsystem.util.PageNumber;
import ssru.myw.agentsystem.util.memonto.PageNumberCareTaker;

import java.util.ArrayList;
import java.util.Iterator;
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
    @Autowired
    private ContactsMapper contactsMapper;

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
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @Override
    public Integer saveCustoms(Customs customs) {
        int mybatisreturn =    customsMapper.saveCustoms(customs);


        if (ObjectEmpty.getInstance().isNullOrEmpty(customs.getList())) {
            // 如果list不为空
            List<Contacts> list = customs.getList();
            Iterator<Contacts> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next().setCustomId(customs.getId().longValue());
            }
            int mr = contactsMapper.saveListContacts(list);
        }

        return null;
    }
}
