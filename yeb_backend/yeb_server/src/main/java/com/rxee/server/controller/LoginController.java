package com.rxee.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    //@RequestMapping("login")
    //public String login(){
    //    System.out.println("执行登录方法");
    //    return "redirect:main.html";
    //}

    @RequestMapping("toMain")
    public String toMain(){
        return "redirect:main.html";
    }
    @RequestMapping("toError")
    public String toError(){
        return "redirect:error.html";
    }

    @GetMapping("demo")
    @ResponseBody
    public String demo(){
        return "demo";
    }
}
