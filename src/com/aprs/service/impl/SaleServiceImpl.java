package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.SaleDao;
import com.aprs.entity.Sale;
import com.aprs.service.SaleService;
@Service("saleService")
public class SaleServiceImpl implements SaleService {

	@Resource
	private SaleDao saleDao;
	
	@Override
	public List<Sale> getAll(int start, int end) {
		// TODO Auto-generated method stub

		return saleDao.getAll(start, end);
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub

		return saleDao.getNum();
	}

	@Override
	public List<Sale> getByNo(int sale_id) {
		// TODO Auto-generated method stub

		return saleDao.getByNo(sale_id);
	}

	@Override
	public int getNumByArgs(String date) {
		// TODO Auto-generated method stub

		return saleDao.getNumByArgs(date);
		
	}

	@Override
	public List<Sale> getByArg(String date) {
		// TODO Auto-generated method stub
		return saleDao.getByArg(date);
	}

	@Override
	public void delete(int sale_id) {
		// TODO Auto-generated method stub

		saleDao.delete(sale_id);
	}

}
