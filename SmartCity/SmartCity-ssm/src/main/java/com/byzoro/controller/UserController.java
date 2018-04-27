package com.byzoro.controller;

import com.alibaba.fastjson.JSONArray;
import com.byzoro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

	@RequestMapping("/findAll")
	public String findAll(){
		
        return JSONArray.toJSONString(userService.findAll());
	}
}
