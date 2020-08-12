package com.fengfan.myspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class testcontroller {
    @RequestMapping("")
    public ModelAndView index() {
        System.out.println("访问项目中。。。。");
        ModelAndView view = new ModelAndView("index");
        System.out.println(view);
        return view;
    }

    @RequestMapping("testerror")
    public String hello() throws Exception {
        System.out.println("访问项目中。。。。");
        ModelAndView view = new ModelAndView("index");

        return "error/error";
    }


}
