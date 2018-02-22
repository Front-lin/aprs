package com.aprs.service;

import com.aprs.entity.Employee;

public interface EmployeeService {
	public Employee login(int employee_id,String password);
}
