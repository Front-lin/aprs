package com.aprs.dao;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Employee;

public interface EmployeeDao {
	public Employee login(@Param("employee_id")String employee_id,@Param("password")String password);
}
