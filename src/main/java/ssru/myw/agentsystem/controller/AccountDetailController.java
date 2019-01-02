package ssru.myw.agentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ssru.myw.agentsystem.service.accountdetail.AccountDetailService;

/**
 * @author: mayiwen
 * @date: 2018/12/19
 */
@RestController
@RequestMapping("/accountdetail")
public class AccountDetailController {
    @Autowired
    private AccountDetailService accountdetailService;

    @GetMapping("/page")
    public ModelAndView toAccontDetailListPage(ModelAndView mv) {
        mv.setViewName("AgentAdvicePayment");
        return mv;
    }

}
