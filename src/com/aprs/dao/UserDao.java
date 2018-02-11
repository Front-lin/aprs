package com.aprs.dao;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.User;

public interface UserDao {
	public User login(@Param("username")String username,@Param("password")String password);
}
