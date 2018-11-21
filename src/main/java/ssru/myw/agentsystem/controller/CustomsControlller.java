package ssru.myw.agentsystem.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ssru.myw.agentsystem.entity.Customs;
import ssru.myw.agentsystem.service.customs.CustomsService;
import ssru.myw.agentsystem.util.PageNumber;
import ssru.myw.agentsystem.util.memonto.PageNumberCareTaker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: mayiwen
 * @date: 2018/11/21
 */
@RestController
@RequestMapping("/customs")
public class CustomsControlller {
    @Autowired
    private CustomsService customsService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView toPage(ModelAndView mv) {
        mv.setViewName("customs");
        return mv;
    }
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String listCustomsJson(Customs customs) {
        PageNumberCareTaker pageNumberCareTaker = new PageNumberCareTaker();
        List<Customs> list = new ArrayList<>();
        list = customsService.listCustoms(customs,pageNumberCareTaker);
        PageNumber pageNumber = new PageNumber();
        pageNumber.setMemento(pageNumberCareTaker.getMemento());
        Map map = new HashMap();
        map.put("list", list);
        map.put("pageNumber", pageNumber);
        return JSON.toJSONString(map);
    }


}
