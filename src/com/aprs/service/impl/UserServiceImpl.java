package com.aprs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.UserDao;
import com.aprs.entity.User;
import com.aprs.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

}
