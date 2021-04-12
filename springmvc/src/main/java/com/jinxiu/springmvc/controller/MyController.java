package com.jinxiu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//注解@Controller表示它是一个控制器
@Controller("myController")
//表明当请求的URI在/my下的时候才有该控制器响应
@RequestMapping("/my")
public class MyController {

    // 表明URI时/index时请求该方法
    @RequestMapping("/index")
    public ModelAndView index() {
        // 模型和视图
        ModelAndView mb = new ModelAndView();
        // 视图逻辑名称
        mb.setViewName("index");
        return mb;
    }
}
