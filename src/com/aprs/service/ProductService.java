package com.aprs.service;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

import com.aprs.entity.Product;
import com.aprs.entity.DatatablesViewPage;

public interface ProductService {
	public int getNum();
	public List<Product> getAllProduct(int start,int end);
	public void add(Product product);
	public void updateSale(Product product);
	public void updateQuantity(Product product);
	public void delete(int product_id);
	public DatatablesViewPage<Product> getProductByName(String name);
	public DatatablesViewPage<Product> getViewSP(int start, int end);
}
