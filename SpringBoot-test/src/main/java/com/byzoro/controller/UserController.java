package com.byzoro.controller;

import com.alibaba.fastjson.JSONArray;
import com.byzoro.service.UserService;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

	@RequestMapping("/findAll")
	public String findAll( ServletRequest request, ServletResponse response){
        String str = request.getParameter("postStr");
        System.err.println(str);
        HttpServletResponse resp= (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin","*");
        System.err.println("测试。。。。。。");
        return JSONArray.toJSONString(userService.findAll());
	}
}
