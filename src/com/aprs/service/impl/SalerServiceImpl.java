package com.aprs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.SalerDao;
import com.aprs.entity.Saler;
import com.aprs.service.SalerService;

@Service("salerService")
public class SalerServiceImpl implements SalerService {

	@Resource
	private SalerDao salerDao;
	
	public Saler login(String id, String password) {
		// TODO Auto-generated method stub
		return salerDao.login(id,password);
	}

}
