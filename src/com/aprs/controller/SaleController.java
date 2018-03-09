package com.aprs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.Sale;
import com.aprs.service.SaleService;

@Controller
public class SaleController {
	@Resource
	private SaleService saleService;
	
	private static Logger logger = Logger.getLogger(SaleController.class);
	@RequestMapping(value="/getSale", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Sale> getPurchase(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		System.out.println(123);
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));  
        String state = request.getParameter("state");
        List<Sale> list = null;
        int num = 0;
        if (state.equals("0")){
        	list = saleService.getAll(start, length);
        	num = saleService.getNum();
        } else if (state.equals("1")) {
			list = saleService.getByNo(Integer.parseInt(request.getParameter("sale_id")));
			num = 1;
		}else if (state.equals("2")) {
			String date = request.getParameter("sale_date");
			num = saleService.getNumByArgs(date);
			list = saleService.getByArg(date);
		}else {
			return null;
		}
        DatatablesViewPage<Sale> view = new DatatablesViewPage<Sale>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
	
	@RequestMapping(value="/deleteSale", method=RequestMethod.POST)
	public void deletePurchase(int sale_id,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			saleService.delete(sale_id);
				out.print("true");	
		} catch (Exception e) {
			logger.info("delete",e);
			out.print("false");
		}
	}
}
