package ssru.myw.agentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ssru.myw.agentsystem.entity.User;
import ssru.myw.agentsystem.util.ObjectEmpty;

import javax.servlet.http.HttpSession;

/**
 * @ Author     ：mayiwen.
 * @ Date       ：Created in 9:51 2018/11/3
 */
@Controller
public class SysController {


    @RequestMapping("/")
    public ModelAndView toLoginPage(ModelAndView mv, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (!ObjectEmpty.getInstance().isNullOrEmpty(user)) {
           mv.setViewName("main");
        } else {
            mv.setViewName("login");
        }
       return mv;
    }
}
