package com.fsd.stock.attachment.controller;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fsd.stock.attachment.entity.StockPrice;
import com.fsd.stock.attachment.model.ImportInfo;
import com.fsd.stock.attachment.service.AttachmentService;
import com.fsd.stock.attachment.util.ExcelUtility;

@RestController
public class AttachmentController {

	private static final String FILE = "file";

	@Autowired
	private AttachmentService attachmentService;

	@RequestMapping(value = "/stockprice/attachment", method = RequestMethod.POST)
	public ResponseEntity<ImportInfo> insertAttachment(@RequestParam(FILE) MultipartFile file) throws Exception {
		
		ImportInfo importInfo = new ImportInfo();
		InputStream in = file.getInputStream();
		String[] fileds = { "companycode", "stockexchange", "pricestr", "datestr" };
		String[] titles = { "Company Code", "Stock Exchange", "Price Per Share(in Rs)", "Date" };
		
		List<StockPrice> stockList = ExcelUtility.readExcelSheet(in, 0, fileds, titles, StockPrice.class);
		
		List<StockPrice> resultList = attachmentService.addStockPriceList(stockList);
		int importnumber = resultList.size();
		importInfo.setTotalnumbers(importnumber);
		importInfo.setCompanycode(resultList.get(0).getCompanycode());
		importInfo.setStockexchange(resultList.get(0).getStockexchange());
		importInfo.setStarttime(resultList.get(0).getDate().toString());
		importInfo.setEndtime(resultList.get(importnumber-1).getDate().toString());
		
		ResponseEntity<ImportInfo> response = new ResponseEntity<ImportInfo>(importInfo, HttpStatus.CREATED);
		return response;

	}

	@RequestMapping(value = "/stockprice/all", method = RequestMethod.GET)
	public ResponseEntity<List<StockPrice>> getAll() throws Exception {

		ResponseEntity<List<StockPrice>> response = new ResponseEntity<List<StockPrice>>(attachmentService.getAll(),
				HttpStatus.OK);
		return response;

	}

}
