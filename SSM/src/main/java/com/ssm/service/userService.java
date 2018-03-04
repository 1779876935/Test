package com.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.userDao;
import com.ssm.entity.user;

@Service("userService")
public class userService {
	@Resource
	private userDao userDao;
	
	public List<user> getUsers(){
		List<user> users = userDao.getUsers();
		return users; 
	}
}
