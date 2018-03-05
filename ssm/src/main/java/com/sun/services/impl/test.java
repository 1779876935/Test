package com.sun.services.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.entity.User;
import com.sun.services.userService;

public class test {
	 public static void main(String[] args) {
	        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
	        userService uService = (userService) application.getBean("userServiceImpl");
	        User user = uService.getUserById(1);
	        System.out.println(user.getUserName());
	    }
}
