package com.guotou.springmvc.controller;

import com.alibaba.fastjson.JSONArray;
import com.guotou.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

	@RequestMapping("/findAll")
    @ResponseBody
	public String findAll(){
        String s = JSONArray.toJSONString(userService.findAll());
        return s;
//        return userService.findAll();
	}
}
