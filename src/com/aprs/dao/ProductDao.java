package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import com.aprs.entity.Product;

public interface ProductDao {
	public int getNum();
	public List<Product> getAllProduct(@Param("start")int start,@Param("end")int end);
	public List<Product> getProductByName(@Param("name")String name);
	public void add(Product product) throws DuplicateKeyException;
	public void updateSale(Product product);
	public void updateQuantity(Product product);
	public void delete(int product_id);
}
