package com.aprs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.Product;
import com.aprs.service.ProductService;

@Controller
public class ProductController {
	
	private static Logger logger = Logger.getLogger(ProductController.class);
	
	@Resource
	private ProductService productService;

	@RequestMapping(value="/getAllProduct", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Product> getAllProduct(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));
		return productService.getViewSP(start, length);
	}
	

	@RequestMapping(value="addProduct", method=RequestMethod.POST)
	public void addProduct(Product product,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(product==null){
				out.print("false");
			}else {
				productService.add(product);
				out.print("true");
			}	
		}
		catch (Exception e) {
			logger.info("addProduct",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/deleteProduct", method=RequestMethod.POST)
	public void deleteProduct(int product_id,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
				productService.delete(product_id);
		} catch (Exception e) {
			logger.info("deleteStudents �����ˣ�",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/updateSale", method=RequestMethod.POST)
	public void updateSale(Product product,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(product==null){
				out.print("false");
			}else {
				productService.updateSale(product);
			}	
		} catch (Exception e) {
			logger.info("updateSale �����ˣ�",e);
			out.print("false");
		}
	}
	
}
