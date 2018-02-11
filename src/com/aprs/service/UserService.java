package com.aprs.service;



import com.aprs.entity.User;


public interface UserService {
	public User login(String username,String password);
}
