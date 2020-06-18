package com.fsd.stock.attachment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.attachment.entity.StockPrice;
import com.fsd.stock.attachment.repository.AttachmentRepository;

@Service
public class AttachmentService {
	
	@Autowired
	private AttachmentRepository attachmentRepository;
	
	public List<StockPrice> addStockPriceList(List<StockPrice> list) {
		return attachmentRepository.saveAll(list);
	}
	
	public List<StockPrice> getAll(){
		return attachmentRepository.findAll();
	}

}
