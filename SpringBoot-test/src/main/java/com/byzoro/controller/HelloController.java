package com.byzoro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String info()
    {
        return "hello world。。。";
    }



    @RequestMapping("/login")
    public String login(){
        return "index";
    }
}
