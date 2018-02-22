package com.aprs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aprs.entity.Employee;
import com.aprs.service.EmployeeService;

@Controller
public class EmployeeController {
private static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Resource
	private EmployeeService employeeService;
	
	@RequestMapping(value="employeeLogin",method=RequestMethod.POST)
	public void employeeLogin(int employee_id,String password,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		logger.info("�����¼����");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			Employee employee = employeeService.login(employee_id, password);
			if (employee!=null) {
				session.setAttribute("employee", employee);
				out.print("true");
			}else {
				out.print("false");
			}
			
		} catch (Exception e) {
			out.print("false");
			logger.info("employeeLogin", e);
		}
	}
}
