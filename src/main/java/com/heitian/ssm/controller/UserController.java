package com.heitian.ssm.controller;

import com.google.gson.Gson;
import com.heitian.ssm.pojo.TUser;
import com.heitian.ssm.service.TUserService;
import com.heitian.ssm.service.impl.ITUserService;
import com.heitian.ssm.utils.IPUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private ITUserService itUserService;

    @RequestMapping(value="/showUser",method={RequestMethod.POST})
    @ResponseBody
    public TUser showUser(@RequestBody TUser tUser, HttpServletRequest request, Model model){
        log.info("\n用户IP="+IPUtils.getRemoteAddr(request));
        if (tUser.getId()!=null){
            log.info(tUser.getId()+"");
            return  itUserService.selectTUserId(tUser.getId());
        }else if (tUser.getUserName()!=null) {
            log.info(tUser.getUserName()+"");
            return  itUserService.selectTUserName(tUser.getUserName());
        }
        log.info(tUser.toString());
        return tUser;


    }
//    @RequestMapping("/id")
//    @ResponseBody
//    public List<TUser> selectUserById(@RequestParam(value = "id",required = false,defaultValue = "1") long id, Model model) {
//        TUser user = userService.getUserById((long)id);
//        List<TUser> users = new ArrayList<TUser>();
//        users.add(user);
//        model.addAttribute("userList", users);
//        return users;
//    }
//    @RequestMapping(value = "/showUserId")
//    @ResponseBody
//    public TUser showUserId(@RequestParam Long id){
//        TUser user = userService.getUserById((long)id);
//
//        return user;
//    }
}
