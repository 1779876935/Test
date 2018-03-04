package com.ssm.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ssm.entity.user;
import com.ssm.service.userService;
@Controller
@RequestMapping(value = "/user")
public class userController implements Serializable {
	@Resource
	private userService uservice;

	@RequestMapping(value = "/userList")
	@ResponseBody
	public String getUsers(HttpServletRequest request,Model model){
		List<user> users = uservice.getUsers();
		 String user = JSON.toJSONString(users);
		return user;
	}
	
}
