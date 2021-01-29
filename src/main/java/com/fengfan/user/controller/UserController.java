package com.fengfan.user.controller;

import com.fengfan.user.pojo.UserDetail;
import com.fengfan.user.server.UserDetailService;
import com.fengfan.user.utils.CheckMD5;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author fengfan
 */
@Controller
@RequestMapping("/")
@Log4j2
public class UserController {
    @Resource
    UserDetailService userDetailService;
    @Resource
    CheckMD5 md5;
    @Resource
    RedisTemplate redisTemplate;

    @RequestMapping("/")
    public ModelAndView defaultIndex() {
        System.out.println("首页进入...");
        return new ModelAndView("index");
    }

    @PostMapping("/index")
    @ResponseBody
    public Map index(UserDetail user) {
        System.out.println("js加载...");
        Map<String, Object> map = new HashMap<>(20);
        UserDetail userDetail = userDetailService.selectByPrimaryKey(1);
        map.put("msg", "ok");
        map.put("user", userDetail);
        System.out.println(map);
        return map;
    }

    @RequestMapping("testerror")
    public ModelAndView hello() {
        System.out.println("访问项目中。。。。");

        return new ModelAndView("error/error");
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody UserDetail user) {
        System.out.println("用户注册");
        Map<String, Object> map = new ConcurrentHashMap<>(10);
        if (null != user && user.getPassword() != null && user.getUserName() != null) {
            UserDetail sel = new UserDetail();
            sel.setUserName(user.getUserName());
            UserDetail userDetail = userDetailService.selectByPrimaryKeySelective(sel);
            if (userDetail != null) {
                map.put("msg", "该名称已经注册,请勿重复注册");
                map.put("user", userDetail);
                return map;
            }
            user.setPassword(md5.getMd5Pass(user.getPassword()));
            user.setUserRegistertime(new Date());
            user.setUserUpdatetime(new Date());
            int i = userDetailService.insertSelective(user);
            if (i > 0) {
                map.put("msg", "注册成功");
            } else {
                map.put("msg", "注册失败");
            }
            map.put("user", user);
        } else {
            map.put("msg", "用户名,密码不能为空");
        }
        return map;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody UserDetail user) {
        System.out.println("用户登录");
        System.out.println(UUID.randomUUID().toString());
        Map<String, Object> map = new ConcurrentHashMap<>(20);
        if (null != user) {
            UserDetail userDetail = userDetailService.selectByUserName(user.getUserName());
            if (null != userDetail) {
                if (md5.checkPassword(user.getPassword(), userDetail.getPassword())) {
                    String uuid = UUID.randomUUID().toString();
                    log.info(userDetail);
                    redisTemplate.opsForValue().set(uuid, userDetail, 500L, TimeUnit.MINUTES);
                    map.put("msg", "登录成功!");
                    map.put("key", uuid);
                } else {
                    map.put("msg", "用户名或密码错误,请重试");
                    return map;
                }
            } else {
                map.put("msg", "用户不存在,换个手机号或用户名试试吧");
                return map;
            }
        }
        return map;


        
    }


}
