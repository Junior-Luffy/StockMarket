package com.fsd.stock.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.company.entity.Company;
import com.fsd.stock.company.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/company")
	public List<Company> getAll(){
		return companyService.findAll();
	}
	
	@GetMapping("/company/{id}")
	public Company getById(@PathVariable Long id) {
		return companyService.findById(id);
	}
	
	@PostMapping("/company/save")
	public Company save(@RequestBody Company company) {
		return companyService.save(company);
	}
	
	@DeleteMapping("/company/{id}")
	public void deleteById(@PathVariable Long id) {
		companyService.delete(id);
	}

}
