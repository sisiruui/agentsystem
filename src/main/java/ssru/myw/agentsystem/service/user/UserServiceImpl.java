package ssru.myw.agentsystem.service.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.UserMapper;
import ssru.myw.agentsystem.entity.User;
import ssru.myw.agentsystem.util.ObjectEmpty;
import ssru.myw.agentsystem.util.PageNumber;
import ssru.myw.agentsystem.util.StringUtil;
import ssru.myw.agentsystem.util.memonto.PageNumberCareTaker;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：mayiwen.
 * @ Date       ：Created in 16:29 2018/11/2
 */
@Service("userService")
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService{
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    //    @Transactiona(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> listUser(User user, Integer flag, PageNumberCareTaker pageNumberCareTaker) {
        List<User> list = new ArrayList<>();
        if (flag == 1) {
            int pageNum = (user.getThePage() - 1) * 10;
            user.setPageStartNum(pageNum);
            user.setPageSize(10);
            list = userMapper.listUser(user);
            PageNumber pageNumber = new PageNumber(user.getThePage(), userMapper.countUser(user));
            pageNumberCareTaker.setMemento(pageNumber.createMemento());
        } else {
            list = userMapper.listUser(user);
        }
        return list;

    }

    public Integer countUser(User user) {
        return userMapper.countUser(user);
    }
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @Override
    public Integer saveUser(User user) {
        return userMapper.saveUser(user);
    }
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @Override
    public int updateUser(User user) {
        user.setUserPassword(StringUtil.getInstance().md5(user.getUserPassword()));
        return userMapper.updateUser(user);
    }
}
