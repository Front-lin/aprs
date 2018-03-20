package com.aprs.service;

import com.aprs.entity.ClassifyDetail;
import com.aprs.entity.DatatablesViewPage;

public interface ClassifyDetailService {
	public void delete(int cid);
	public void deleteDetail(int cid);
	public void add(ClassifyDetail classifyDetail );
	public DatatablesViewPage<ClassifyDetail> queryDetail(int id, int start, int end);
}
