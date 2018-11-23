package ssru.myw.agentsystem.dao;

import ssru.myw.agentsystem.entity.Contacts;

import java.util.List;

public interface ContactsMapper {
    int saveListContacts(List<Contacts> list);
}
