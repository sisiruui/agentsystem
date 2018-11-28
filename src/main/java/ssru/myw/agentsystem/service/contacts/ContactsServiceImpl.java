package ssru.myw.agentsystem.service.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.ContactsMapper;
import ssru.myw.agentsystem.entity.Contacts;
import ssru.myw.agentsystem.entity.Customs;

import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/26
 */
@Service
@Transactional(readOnly=true)
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsMapper contactsMapper;

    @Override
    public List<Contacts> listContacts(Contacts contacts) {
        return contactsMapper.listContacts(contacts);
    }
}
