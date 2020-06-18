package com.fsd.stock.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.company.entity.StockExchange;
import com.fsd.stock.company.repository.StockExchangeRepository;

@Service
public class StockExchangeService {
	@Autowired
	private StockExchangeRepository stockExchangeRepository;
	
	public StockExchange save(StockExchange stockExchange) {
		return stockExchangeRepository.save(stockExchange);
	}
	
	public void delete(Long id) {
		stockExchangeRepository.deleteById(id);
	}
	
	public List<StockExchange> findAll(){
		return stockExchangeRepository.findAll();
	}
	
	public StockExchange findById(Long id) {
		Optional<StockExchange> result = stockExchangeRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

}
