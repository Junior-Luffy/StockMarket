package com.fsd.stock.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.company.entity.Ipo;
import com.fsd.stock.company.service.IpoService;

@RestController
public class IpoController {
	
	@Autowired
	private IpoService ipoService;
	
	@GetMapping("/ipo")
	public List<Ipo> getAll(){
		return ipoService.findAll();
	}
	
	@GetMapping("/ipo/{id}")
	public Ipo getById(@PathVariable Long id) {
		return ipoService.findById(id);
	}
	
	@PostMapping("/ipo/save")
	public Ipo save(@RequestBody Ipo ipo) {
		return ipoService.save(ipo);
	}
	
	@DeleteMapping("/ipo/{id}")
	public void deleteById(@PathVariable Long id) {
		ipoService.delete(id);
	}

}
