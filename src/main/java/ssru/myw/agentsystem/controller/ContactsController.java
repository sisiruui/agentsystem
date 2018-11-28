package ssru.myw.agentsystem.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssru.myw.agentsystem.entity.Contacts;
import ssru.myw.agentsystem.entity.Customs;
import ssru.myw.agentsystem.service.contacts.ContactsService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/26
 */
@RestController
@RequestMapping("/contacts")
public class ContactsController {
    @Autowired
    private ContactsService contactsService;

    @GetMapping("/json")
    public String listContacts(Customs customs) {
        Contacts contacts = new Contacts();
        contacts.setCustomId(customs.getId());
        List<Contacts> list = new ArrayList<>();
        list = contactsService.listContacts(contacts);
        return JSON.toJSONString(list);
    }





}
