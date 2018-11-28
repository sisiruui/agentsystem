package ssru.myw.agentsystem.dao;

import ssru.myw.agentsystem.entity.Contacts;
import ssru.myw.agentsystem.entity.Customs;

import java.util.List;

public interface ContactsMapper {
    int saveListContacts(List<Contacts> list);

//    Customs listCustoms(Customs customs);

    List<Contacts> listContacts(Contacts contacts);


    List<Integer> listContactsId(Integer customsId);

    int updateListContacts(List<Contacts> list);
}
