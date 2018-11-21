package ssru.myw.agentsystem.service.user;

import org.springframework.stereotype.Service;
import ssru.myw.agentsystem.entity.User;
import ssru.myw.agentsystem.util.PageNumber;
import ssru.myw.agentsystem.util.memonto.PageNumberCareTaker;

import java.util.List;

/**
 * @ Author     ：mayiwen.
 * @ Date       ：Created in 16:27 2018/11/2
 */

public interface UserService {

    public List<User> listUser(User user, Integer flag , PageNumberCareTaker pageNumberCareTaker);
    public Integer countUser(User user) ;


    Integer saveUser(User user);

    int deleteUser(User user);

    int updateUser(User user);
}
