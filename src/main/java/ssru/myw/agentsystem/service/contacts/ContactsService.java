package ssru.myw.agentsystem.service.contacts;

import ssru.myw.agentsystem.entity.Contacts;
import ssru.myw.agentsystem.entity.Customs;

import java.util.List;

public interface ContactsService {

    List<Contacts> listContacts(Contacts contacts);
}
