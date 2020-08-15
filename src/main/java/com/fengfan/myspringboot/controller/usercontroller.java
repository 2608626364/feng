package com.fengfan.myspringboot.controller;

import com.fengfan.myspringboot.pojo.UserDetail;
import com.fengfan.myspringboot.server.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class usercontroller {
    @Autowired
    UserDetailService detailService;
    @RequestMapping("")
    public ModelAndView defaultindex() {
        System.out.println("首页进入...");
        ModelAndView view = new ModelAndView("index");
        return view;
    }
    @PostMapping("/index")
    @ResponseBody
    public ModelAndView index(UserDetail user) {
        System.out.println("js加载...");
        System.out.println(user);
        List<UserDetail> list = detailService.selectAll();
        ModelAndView view = new ModelAndView("index");
        view.addObject("list",list);
        System.out.println(view);
        return view;
    }
    @RequestMapping("testerror")
    public ModelAndView hello() throws Exception {
        System.out.println("访问项目中。。。。");
        ModelAndView view = new ModelAndView("error/error");

        return view;
    }


}
