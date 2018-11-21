package ssru.myw.agentsystem.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ssru.myw.agentsystem.entity.Role;
import ssru.myw.agentsystem.entity.SystemConfig;
import ssru.myw.agentsystem.entity.User;
import ssru.myw.agentsystem.message.JsonMessage;
import ssru.myw.agentsystem.service.role.RoleService;
import ssru.myw.agentsystem.util.ObjectEmpty;
import ssru.myw.agentsystem.util.StringUtil;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView toRolePage(ModelAndView mv) {
        mv.setViewName("role");
        return mv;
    }

    /**
     * 这是获得所有的role角色列表，返回json数据
     * @return
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String roleList() {
        // 得到所有的role 角色
        List<Role> list = new ArrayList<>();
        list = roleService.listRole(new Role());
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addRole(@RequestBody Role role, HttpSession session) {
        String message = "";
        System.out.println(role.toString());
        // 首先 role不能为空，及RoleName isStart不可以为空
        if (ObjectEmpty.getInstance().isNullOrEmpty(role) ||
                ObjectEmpty.getInstance().isNullOrEmpty(role.getRoleName()) ||
                ObjectEmpty.getInstance().isNullOrEmpty(role.getIsStart())) {
            message = JsonMessage.MISSING.toString().toLowerCase();
        } else {
            // 在session 中user 不可以为空 这个统一判断 没有session就跳转到主页 在这里不做单独判断
            User loginUser = new User();
            loginUser = (User) session.getAttribute("user");
            role.setCreatedBy(loginUser.getUserCode());
            role.setCreationTime(new Date());
            role.setLastUpdateTime(new Date());
            // 当前的role信息都存在后直接插入
            int mybatisMessage = 0;
            try {
                mybatisMessage = roleService.saveRole(role);
            } catch (Exception e) {
                e.printStackTrace();
                mybatisMessage = -1;
            } finally {
            }
            if (mybatisMessage == 0) {
                message = JsonMessage.FAILURE.toString().toLowerCase();
            } else if (mybatisMessage == -1){
                message = JsonMessage.EXCEPTION.toString().toLowerCase();
            } else {
                message = JSON.toJSONString(role);
            }
        }
        return message;
    }
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @RequestMapping(value = "/id/{urlId}", method = RequestMethod.DELETE)
    public String deleteRole(@PathVariable Integer urlId,
            @RequestBody Role role, HttpSession httpSession) {
        //如果session失效要跳到首页重新登录，这个批量处理，不在这里验证，不能乱七八糟的人乱删东西
        String message = "";
        int mybatisReturn = 0;
        try {
            mybatisReturn = roleService.deleteRole(role);
        } catch (Exception e) {
            mybatisReturn = -1;
        } finally {
        }

        message = StringUtil.getInstance().mybatisReturnMessage(mybatisReturn, null);
        return message;
    }

    /**
     * 修改的方法
     * @param urlId
     * @param role
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @RequestMapping(value = "/id/{urlId}", method = RequestMethod.PUT)
    public String updateRole(@PathVariable Integer urlId,
            @RequestBody Role role) {
        //，返回的消息用message接收
        String message = "";
        int mybatisReturn = 0;
        try {
            mybatisReturn = roleService.updateRole(role);
        } catch (Exception e) {
            mybatisReturn = -1;
        } finally {
        }
        message = StringUtil.getInstance().mybatisReturnMessage(mybatisReturn, null);
        return message;
    }









}
