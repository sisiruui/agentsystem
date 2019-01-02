package ssru.myw.agentsystem.controller;

import com.sun.org.apache.bcel.internal.generic.I2F;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ssru.myw.agentsystem.entity.Keywords;
import ssru.myw.agentsystem.entity.User;
import ssru.myw.agentsystem.message.JsonMessage;
import ssru.myw.agentsystem.service.keywords.KeywordsService;
import ssru.myw.agentsystem.util.DateUtil;
import ssru.myw.agentsystem.util.StringUtil;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author: mayiwen
 * @date: 2018/11/29
 */
@RestController
@RequestMapping("/keywords")
public class KeywordsController {
    @Autowired
    private KeywordsService keywordsService;
    @GetMapping("/page")
    public ModelAndView toAddKeywordsPage(ModelAndView mv) {
        mv.setViewName("keywords");
        return mv;
    }
    /** 验证密码 */
    @GetMapping("/check/keywords")
    public String checkKeywords(Keywords keywords) {
        String returnMessage = "";
        int count = keywordsService.count(keywords);
        if (count > 0) {
            returnMessage = JsonMessage.SUCCESS.toString().toLowerCase();
        } else {
            returnMessage = JsonMessage.FAILURE.toString().toLowerCase();
        }

        return returnMessage;
    }
    @PostMapping("")
    public String saveKeywords(@RequestBody Keywords keywords, HttpSession session) {
        System.out.println(keywords.toString());
//        [keywords=ss, agentId=0, agentName=, customId=27, customName=g1111, preRegFrozenMoney=0, price=52000, productType=1, serviceYears=2, openApp=0, appUserName=, appPassword=, loginUrl=, iosDownloadUrl=, androidDownloadUrl=, codeIosUrl=, codeAndroidUrl=null, preRegDatetime=null, preRegPassDatetime=null, regDatetime=null, regPassDatetime=null, isPass=0, checkStatus=0, isUse=0]
        // 上面是前端返回的例子 下面补充没有从前端获取的数据
        User loginUser = (User) session.getAttribute("user");
        keywords.setAgentId(loginUser.getId());
        keywords.setAgentName(loginUser.getUserName());
        keywords.setPreRegFrozenMoney(keywords.getPrice());
        keywords.setRegDatetime(new Date());
        keywords.setRegPassDatetime(DateUtil.getNextMouthDate(new Date()));
        keywords.setIsPass(0); // 设置审核状态为已申请
        keywords.setCheckStatus(0); // 设置为0为不过期
        keywords.setIsUse(1); // 设置为1表示已经可以使用了

        // 在数据库中添加keywords
        int rows = 0;
        try {
            rows = keywordsService.saveKeywords(keywords);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        // 直接返回信息
        return StringUtil.getInstance().mybatisReturnMessage(rows, null);
    }




}
