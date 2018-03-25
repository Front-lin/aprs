package com.aprs.dao;

import java.util.List;

import com.aprs.entity.SaleDetail;

public interface SaleDetailDao {
	List<SaleDetail> queryDetail(int id, int start, int end);
	public int selectNum(int id);
	public void settle(List<SaleDetail> saleDetails);
}
