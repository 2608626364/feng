package com.fengfan.user.controller;

import com.fengfan.user.pojo.UserDetail;
import com.fengfan.user.server.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class usercontroller {
    @Autowired
    UserDetailService detailService;
    @RequestMapping("")
    public ModelAndView defaultindex() {
        System.out.println("首页进入...");
        List<UserDetail> list = detailService.selectAll();
        ModelAndView view = new ModelAndView("index");
        view.addObject("list",list);
        return view;
    }
    @PostMapping("/index")
    @ResponseBody
    public Map index(UserDetail user) {
        System.out.println("js加载...");
        List<UserDetail> list = detailService.selectAll();
        ModelAndView view = new ModelAndView("index");
        view.addObject("list",list);
        Map<String,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("list",list);
        System.out.println(map);
        return map;
    }
    @RequestMapping("testerror")
    public ModelAndView hello() throws Exception {
        System.out.println("访问项目中。。。。");
        ModelAndView view = new ModelAndView("error/error");

        return view;
    }


}
