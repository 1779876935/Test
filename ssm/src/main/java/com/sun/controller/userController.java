package com.sun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.entity.User;
import com.sun.services.userService;

@Controller
@RequestMapping(value = "/user")
public class userController {
	@Resource
	private userService userService;
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String test(@RequestParam("uid") int uid,HttpServletRequest request,Model model){
		User user = userService.getUserById(uid);
		if (user == null) {
			return "error";
		}
		request.setAttribute("name", user.getUserName());
		model.addAttribute("name",user.getUserName());
		return "success";
	}
}
