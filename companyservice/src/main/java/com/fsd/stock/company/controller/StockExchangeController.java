package com.fsd.stock.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.company.entity.StockExchange;
import com.fsd.stock.company.service.StockExchangeService;

@RestController
public class StockExchangeController {
	
	@Autowired
	private StockExchangeService stockExchangeService;
	
	@GetMapping("/stockexchange")
	public List<StockExchange> getAll(){
		return stockExchangeService.findAll();
	}
	
	@GetMapping("/stockexchange/{id}")
	public StockExchange getById(@PathVariable Long id) {
		return stockExchangeService.findById(id);
	}
	
	@PostMapping("/stockexchange/save")
	public StockExchange save(@RequestBody StockExchange StockExchange) {
		return stockExchangeService.save(StockExchange);
	}
	
	@DeleteMapping("/stockexchange/{id}")
	public void deleteById(@PathVariable Long id) {
		stockExchangeService.delete(id);
	}
}
