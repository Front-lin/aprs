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

import com.aprs.entity.User;
import com.aprs.service.UserService;

@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	//登录
	@RequestMapping(value="userLogin",method=RequestMethod.POST)
	public void userLogin(String username,String password,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		logger.info("进入登录方法");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			User user = userService.login(username, password);
			if (user!=null) {
				session.setAttribute("user", user);
				out.print("true");
			}else {
				out.print("false");
			}
			
		} catch (Exception e) {
			out.print("false");
			logger.info("userLogin", e);
		}
	}

}
