package ssru.myw.agentsystem.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ssru.myw.agentsystem.entity.Account;
import ssru.myw.agentsystem.entity.User;
import ssru.myw.agentsystem.service.account.AccountService;

import javax.servlet.http.HttpSession;

/**
 * @author: mayiwen
 * @date: 2018/11/28
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /** 根据当前登录账号的userId 获得Account列表 */
    @GetMapping("/json")
    public String getAccountByUserId( HttpSession session) {
        User loginUser = (User) session.getAttribute("user");
        Account account =  accountService.getAccountByUserId(loginUser.getId());
        return JSON.toJSONString(account);
    }






}
