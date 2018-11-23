package ssru.myw.agentsystem.controller;

import com.alibaba.fastjson.JSON;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ssru.myw.agentsystem.entity.Role;
import ssru.myw.agentsystem.entity.User;
import ssru.myw.agentsystem.message.JsonMessage;
import ssru.myw.agentsystem.service.user.UserService;
import ssru.myw.agentsystem.util.ObjectEmpty;
import ssru.myw.agentsystem.util.PageNumber;
import ssru.myw.agentsystem.util.StringUtil;
import ssru.myw.agentsystem.util.memonto.PageNumberCareTaker;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;


/**
 * @ Author     ：mayiwen.
 * @ Date       ：Created in 13:55 2018/11/2
 */

@RestController
@EnableTransactionManagement
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;


//    @RequestMapping(value = "/getUserById", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
//    public User getUser(User user) {
//
//        return userService.getUser(user);
//
//    }

    @RequestMapping("/message/login")
    public String login(@RequestBody User user, HttpSession httpSession) {
        String message;
        // 前端页面也要验证。
        System.out.println(user.getUserCode());
        if (ObjectEmpty.getInstance().isNullOrEmpty(user)) { // 验证账号密码
            message = "noinput";

        } else if (ObjectEmpty.getInstance().isNullOrEmpty(user.getUserCode().trim())) { // 验证账号，密码
            message = "nousercode";
        } else if (ObjectEmpty.getInstance().isNullOrEmpty(user.getUserPassword().trim())) { // 验证密码
            message = "nopassword";
        } else {
            // 开始登录 先转md5
            user.setUserPassword(StringUtil.getInstance().md5(user.getUserPassword().trim()));
            user.setUserCode(user.getUserCode().trim());
            List<User> loginUserList = userService.listUser(user,0,null);

            if (ObjectEmpty.getInstance().isNullOrEmpty(loginUserList)) {
                message = "nouser"; // 账户或密码错误
            } else {
                message = "success"; // 登录成功
                User loginUser = loginUserList.get(0);
                loginUser.setUserPassword(""); // 把密码设置为空，避免网页中的session带着密码。
                // 把登录的用户放到session里面
                httpSession.setAttribute("user", loginUser);


            }
        }

        return message;
    }
    @RequestMapping("/href/balance")
    public ModelAndView balance(ModelAndView mv, HttpSession session) {
        // 获取到没有密码的存放到session中user
        User user = (User) session.getAttribute("user");
        if (ObjectEmpty.getInstance().isNullOrEmpty(user)){
            session.invalidate();
            mv.setViewName("login");
        } else {
            mv.setViewName("main");
            mv.addObject("user", user);
        }
        return mv;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView toUserPage(ModelAndView mv) {
        mv.setViewName("user");
        return mv;
    }

    /**
     * 获得所有的 user
     * @param user 根据条件查user
     * @return 返回的是user的列表
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String userListJson(User user) {
//        System.out.println(user.toString());
//        int pageNum = (user.getThePage() - 1) * 10;
//        System.out.println("------------------pageNum 是" + pageNum);
//        PageHelper.startPage(pageNum, 10);
        // 接受返回的User

        List<User> list = new ArrayList<>();

        int flag = 1;
        if (flag == 1) {
            PageNumberCareTaker pageNumberCareTaker = new PageNumberCareTaker();
            list = userService.listUser(user,1, pageNumberCareTaker);
            PageNumber pageNumber = new PageNumber();
            pageNumber.setMemento(pageNumberCareTaker.getMemento());
            Map map = new HashMap();
            map.put("list", list);
            map.put("pageNumber", pageNumber);
            return JSON.toJSONString(map);
        }





        return JSON.toJSONString(list);
    }

    /**
     * 传入对应的属性，来判断是否存在有该属性的对象
     * @param user
     * @return
     */
    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    public String toTestExist(User user) {
        String returmMessage = "";
        Integer integer =  userService.countUser(user);
        System.out.println(integer);
        if (integer > 0) {
            returmMessage = JsonMessage.SUCCESS.toString().toLowerCase();
        } else {
            returmMessage = JsonMessage.FAILURE.toString().toLowerCase();
        }



        return returmMessage;
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveUser( @RequestBody  User user, HttpSession session) {
//        "userCode": self.user.userCode,
//                "userName": self.user.userName,
//                "password": self.user.password,
//                "roleId": self.user.roleId,
//                "isStart": self.user.isStart,
        User loginUser = (User) session.getAttribute("user");
        user.setCreationTime(new Timestamp(System.currentTimeMillis()));
        user.setCreatedBy(user.getUserCode());
        String returmMessage = "";
        Integer integer =  userService.saveUser(user);
        System.out.println(integer);
        if (integer > 0) {
            returmMessage = JsonMessage.SUCCESS.toString().toLowerCase();
        } else {
            returmMessage = JsonMessage.FAILURE.toString().toLowerCase();
        }
        return returmMessage;
    }

    @RequestMapping(value = "/id/{urlId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer urlId,
            @RequestBody User user, HttpSession httpSession) {
        // 首先

        String message = "";
        int mybatisReturn = 0;
        try {
            mybatisReturn = userService.deleteUser(user);
        } catch (Exception e) {
            mybatisReturn = -1;
        } finally {
        }

        message = StringUtil.getInstance().mybatisReturnMessage(mybatisReturn, null);
        return message;
    }
    @RequestMapping(value = "/id/{urlId}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Integer urlId,
            @RequestBody User user, HttpSession httpSession) {
        // 首先
        System.out.println("执行了");
        String message = "";
        int mybatisReturn = 0;
        try {

            mybatisReturn = userService.updateUser(user);
        } catch (Exception e) {
            mybatisReturn = -1;
        } finally {
        }

        message = StringUtil.getInstance().mybatisReturnMessage(mybatisReturn, null);
        return message;
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String checkUser(User user, HttpSession httpSession) {

        String returnMessage = "";
        if (!ObjectEmpty.getInstance().isNullOrEmpty(user.getUserPassword())) {
            user.setUserPassword(StringUtil.getInstance().md5(user.getUserPassword()));
            int countReturn = userService.countUser(user);
            returnMessage = StringUtil.getInstance().mybatisReturnMessage(countReturn, null);
        } else {
            returnMessage = JsonMessage.EXCEPTION.toString().toLowerCase();
        }



        return returnMessage;
    }
    @RequestMapping(value = "/invalidate", method = RequestMethod.GET)
    public ModelAndView invalidate(ModelAndView mv, HttpSession session) {
        session.invalidate();
        mv.setViewName("login");
        return mv;
    }







}
