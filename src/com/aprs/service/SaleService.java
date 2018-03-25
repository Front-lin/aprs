package com.aprs.service;

import java.util.List;

import com.aprs.entity.Sale;

public interface SaleService {
	public List<Sale> getAll(int start,int end);
	public int getNum();
	public List<Sale> getByNo(int sale_id);
	public int getNumByArgs(String sale_date);
	public List<Sale> getByArg(String sale_date);
	public void delete(int sale_id);
	public void settle(int[][] sales, double sum);
}
