package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.ClassifyDao;
import com.aprs.dao.ClassifyDetailDao;
import com.aprs.entity.Classify;
import com.aprs.service.ClassifyDetailService;
import com.aprs.service.ClassifyService;
@Service("classifyDetailService")
public class ClassifyDetailServiceImpl implements ClassifyDetailService {

	@Resource
	private ClassifyDetailDao classifyDetailDao;

	


	@Override
	public void delete(int cid) {
		// TODO Auto-generated method stub
		classifyDetailDao.delete(cid);
		
	}



}
