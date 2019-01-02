package ssru.myw.agentsystem.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ssru.myw.agentsystem.entity.SystemConfig;
import ssru.myw.agentsystem.service.systemconfig.SystemConfigService;
import ssru.myw.agentsystem.util.ObjectEmpty;
import ssru.myw.agentsystem.util.StringUtil;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayiwen
 * @date: 2018/11/6
 */
@RestController
@RequestMapping("systemconfig")
public class SystemConfigController {
    @Autowired
    private SystemConfigService systemConfigService;

    /**
     * 页面跳转
     * 获得所有的财务管理设置
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/financial", method = RequestMethod.GET)
    public ModelAndView toLoginPage(ModelAndView mv) {
        mv.setViewName("systemconfig/financial");
//        // 首先获取 configType 为1的所有 即获取所有的财务类型
//        List<SystemConfig> list = new ArrayList<>();
//        SystemConfig getTypeSystemConfig = new SystemConfig();
//        getTypeSystemConfig.setConfigType(1);
//        list = systemConfigService.listSystemConfig(getTypeSystemConfig);
//        mv.addObject("list", list);
        return mv;
    }

    /**
     * 页面跳转
     * 服务类型
     * @param mv
     * @return
     */
    @RequestMapping(value = "/typeofservice", method = RequestMethod.GET)
    public ModelAndView toTypeOfServicePage(ModelAndView mv) {
        mv.setViewName("systemconfig/typeofservice");
        return mv;
    }

    /**
     * 页面跳转
     * 服务年限
     * @param mv
     * @return
     */
    @RequestMapping(value = "/seniority", method = RequestMethod.GET)
    public ModelAndView toTypeSeniorityPage(ModelAndView mv) {
        mv.setViewName("systemconfig/seniority");
        return mv;
    }

    /**
     * 页面跳转
     * app 地址
     * @param mv
     * @return
     */
    @RequestMapping(value = "/appaddress", method = RequestMethod.GET)
    public ModelAndView toAppAddressPage(ModelAndView mv) {
        mv.setViewName("systemconfig/appaddress");
        return mv;
    }

    /**
     * 页面跳转
     * 去客户类型
     * @param mv
     * @return
     */
    @RequestMapping(value = "/clienttype", method = RequestMethod.GET)
    public ModelAndView toClientTypePage(ModelAndView mv) {
        mv.setViewName("systemconfig/clienttype");
        return mv;
    }

    /**
     * 页面跳转
     * 证件类型
     * @param mv
     * @return
     */
    @RequestMapping(value = "/idtype", method = RequestMethod.GET)
    public ModelAndView toIdTypePage(ModelAndView mv) {
        mv.setViewName("systemconfig/idtype");
        return mv;
    }

    /**
     * 页面跳转
     * 去优惠类型
     * @param mv
     * @return
     */
    @RequestMapping(value = "/preperential", method = RequestMethod.GET)
    public ModelAndView toPreperentialPage(ModelAndView mv) {
        mv.setViewName("systemconfig/preperential");
        return mv;
    }


    /**
     * 登录界面的方法
     * @return
     */
    @RequestMapping(value = "/financial/json", method = RequestMethod.GET)
    public String toLoginPage( ) {

        // 首先获取 configType 为1的所有 即获取所有的财务类型
        List<SystemConfig> list = new ArrayList<>();
        SystemConfig getTypeSystemConfig = new SystemConfig();
        getTypeSystemConfig.setConfigType(1);
        list = systemConfigService.listSystemConfig(getTypeSystemConfig);

        return  JSON.toJSONString(list);
    }
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String listSystemConfigJson( SystemConfig systemConfig ) {
        System.out.println(systemConfig.toString());
        // 首先获取 configType 为1的所有 即获取所有的财务类型
        List<SystemConfig> list = new ArrayList<>();
        list = systemConfigService.listSystemConfig(systemConfig);
        return  JSON.toJSONString(list);
    }
    @RequestMapping(value = "/financial", method = RequestMethod.POST)
    public String addSystemConfig(ModelAndView mv, @RequestBody SystemConfig systemConfig) {

        // 首先是 systemConfig
        System.out.println(systemConfig.toString());
        // 如果 getConfigTypeName 是空的话就没必要添加了
        if (ObjectEmpty.getInstance().isNullOrEmpty(systemConfig) ||
                ObjectEmpty.getInstance().isNullOrEmpty(systemConfig.getConfigTypeName())) {

            return  "nohave";
        }
        // 如果 如果getConfigType 是2或7，那么getConfigValue也不可以为空
        if (systemConfig.getConfigType() == 2 || systemConfig.getConfigType() == 7) { // 如果是服务类型 那么
            if (ObjectEmpty.getInstance().isNullOrEmpty(systemConfig.getConfigValue())) {
                return  "nohave";
            }
        }
        // 如果 如果getConfigType 7，那么getConfigValue也不可以为空
        if (systemConfig.getConfigType() ==  7) { // 如果是服务类型 那么
            if (ObjectEmpty.getInstance().isNullOrEmpty(systemConfig.getConfigTypeValue())) {
                return  "nohave";
            }
        }

        int mybatisResult = 0;
        try {
            mybatisResult  = systemConfigService.saveSystemConfig(systemConfig);// 添加数据
        } catch (Exception e) {
            mybatisResult = -1;
        } finally {
        }

        if (mybatisResult > 0) {
            return   JSON.toJSONString(systemConfig);
        } else {
            return "failuer";
        }








    }
    @RequestMapping(value = "/id/{urlId}", method = RequestMethod.DELETE)
    public int deleteSystemConfig(@PathVariable Integer urlId,
            @RequestBody SystemConfig systemConfig, HttpSession httpSession) {
        //如果session失效要跳到首页重新登录，这个批量处理，不在这里验证，不能乱七八糟的人乱删东西
        int deleteReturn = 0;
        try {
            deleteReturn = systemConfigService.deleteSystemConfig(systemConfig);
        } catch (Exception e) {
            deleteReturn = -1;
        } finally {
        }
        return deleteReturn;
    }
    @RequestMapping(value = "/id/{urlId}", method = RequestMethod.PUT)
    public int updateSystemConfig(@PathVariable Integer urlId,
            @RequestBody SystemConfig systemConfig, HttpSession httpSession) {
        //如果session失效要跳到首页重新登录，这个批量处理，不在这里验证，不能乱七八糟的人乱删东西
        int updateReturn = 0;
        try {
            System.out.println(systemConfig.toString());
            updateReturn = systemConfigService.updateSystemConfig(systemConfig);
        } catch (Exception e) {
            updateReturn = -1;
            e.printStackTrace();
        } finally {
        }
        return updateReturn;
    }

}
