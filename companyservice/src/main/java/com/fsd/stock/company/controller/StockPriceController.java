package com.fsd.stock.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.company.model.SearchCondition;
import com.fsd.stock.company.service.StockPriceService;

@RestController
public class StockPriceController {
	
	@Autowired
	private StockPriceService stockPriceService;
	
	@PostMapping("/stockprice/query")
	public List getChatData(@RequestBody SearchCondition searchCondition) {
		return stockPriceService.query(searchCondition);
	}
}
