package com.fsd.stock.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.company.model.SearchCondition;
import com.fsd.stock.company.repository.StockPriceRepository;

@Service
public class StockPriceService {
	@Autowired
	private StockPriceRepository stockPriceRepository;

	public List query(SearchCondition searchCondition) {
		String[] companynames = searchCondition.getCompanynames();
		List result = new ArrayList();
		for (int i = 0; i < companynames.length; i++) {
			searchCondition.setCompanyname(companynames[i]);
			result.add(stockPriceRepository.getStockPrice(searchCondition));
		}
		return result;
	}

}
