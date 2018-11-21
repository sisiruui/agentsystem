package ssru.myw.agentsystem.dao;


import ssru.myw.agentsystem.entity.User;

import java.util.List;

/**
 * @ Author     ：mayiwen.
 * @ Date       ：Created in 13:56 2018/11/2
 */

public interface UserMapper {
        List<User> listUser(User user);
        Integer countUser(User user);


        Integer saveUser(User user);
        Integer updateUser(User user);

        int deleteUser(User user);
}
