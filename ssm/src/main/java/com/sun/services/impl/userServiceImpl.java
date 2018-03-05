package com.sun.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.UserMapper;
import com.sun.entity.User;
import com.sun.services.userService;
@Service
@Transactional
public class userServiceImpl implements userService {
	@Resource
	private UserMapper userMapper;
	public User getUserById(Integer id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	
}
