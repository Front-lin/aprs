package com.aprs.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aprs.entity.User;
import com.aprs.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class userTest {

	@Resource
	private UserService userService;
	
	@Test
	public void test(){
		User user = userService.login("lhl", "123456");
		if (user!=null) {
			System.out.println(user);
		}
	}
}
