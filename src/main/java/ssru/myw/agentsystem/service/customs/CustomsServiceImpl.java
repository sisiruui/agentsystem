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
        int mybatisreturn = 0;
        int mr = 0;
        try {
            mybatisreturn =    customsMapper.saveCustoms(customs);
        } catch (Exception e){
            mybatisreturn = -1;
            e.printStackTrace();
        } finally {
        }


        if (!ObjectEmpty.getInstance().isNullOrEmpty(customs.getList())) {
            // 如果list不为空
            List<Contacts> list = customs.getList();
            Iterator<Contacts> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next().setCustomId(customs.getId());
            }
            try {
                mr = contactsMapper.saveListContacts(list);
            } catch (Exception e) {
                e.printStackTrace();
                mr = -1;
            } finally {
            }
        }
        boolean flag = false;
        if (ObjectEmpty.getInstance().isNullOrEmpty(customs.getList())) {
            flag = true;
        } else if (mr > 0){
            flag = true;
        } else {
            flag = false;
        }


        if (mybatisreturn > 0 && flag) {
            mybatisreturn = 1;
        } else if (mybatisreturn == -1 || mr == -1) {
            mybatisreturn = -1;
        } else {
            mybatisreturn = 0;
        }





        return mybatisreturn;
    }

    @Override
    public Customs getCustoms(Customs customs) {
        return customsMapper.listCustoms(customs).get(0);
    }
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @Override
    public int updateCustoms(Customs customs) {
        // 修改 customs 表
        int returnMessage = 0;
        int mr = 0;
        int error = 0;
        try {
            returnMessage = customsMapper.updateCustoms(customs);
        } catch (Exception e) {
            e.printStackTrace();
            error = 1;
        } finally {
        }
        // 修改 contacts表
        if (!ObjectEmpty.getInstance().isNullOrEmpty(customs.getList())) {
            // 如果list不为空
            List<Contacts> list = customs.getList(); // 获得所有的contacts
            // 首先在数据库中获得该customsid的contacts
            List<Integer> contactsIdList = contactsMapper.listContactsId(customs.getId()); // 数据库中存在的
            List<Contacts> addList = new ArrayList<>();
            List<Contacts> updateList = new ArrayList<>();
            Iterator<Contacts> iterator = list.iterator();
            Contacts iteratorContacts = null;
            while (iterator.hasNext()) {
                iteratorContacts = new Contacts();
                iteratorContacts = iterator.next();
                if (contactsIdList.contains(iteratorContacts.getId())) { // 如果数据库中存在执行修改 放到updateList
                    updateList.add(iteratorContacts);
                } else { // 如果不存在，则执行修改操作
                    addList.add(iteratorContacts);
                }
            }
            // 然后分别执行
            if (!ObjectEmpty.getInstance().isNullOrEmpty(addList)) { // 如果添加列表不为空，执行添加操作
                // 添加的就跟之前添加的一样
                Iterator<Contacts> addIterator = addList.iterator();
                while (addIterator.hasNext()) { // 给所有待添加的对象添加该customs的id
                    addIterator.next().setCustomId(customs.getId());
                }
                try {
                    mr = contactsMapper.saveListContacts(addList);
                } catch (Exception e) {
                    e.printStackTrace();
                    error = 1;
                } finally {
                }
            }
            if (!ObjectEmpty.getInstance().isNullOrEmpty(updateList)) {
                // 执行update的方法
                System.out.println(updateList.toString());
                try {
                  contactsMapper.updateListContacts(updateList);
                } catch (Exception e) {
                    e.printStackTrace();
                    error = 1;
                } finally {

                }
            }



        }

        if (error == 1) {
            returnMessage = -1;
        }
        return  returnMessage;


    }
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @Override
    public int updateCustomsState(Customs customs) {
        return customsMapper.updateCustoms(customs);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    public List<Customs> listCustomsTopTen(Customs customs) {
        return customsMapper.listCustoms(customs);
    }
}
