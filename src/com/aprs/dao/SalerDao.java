package com.aprs.dao;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Saler;


public interface SalerDao {
	public Saler login(@Param("sid")String id,@Param("spassword")String password);
}
