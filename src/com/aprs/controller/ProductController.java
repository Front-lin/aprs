package com.aprs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
}
