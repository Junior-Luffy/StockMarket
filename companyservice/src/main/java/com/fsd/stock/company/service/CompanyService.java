package com.fsd.stock.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.company.entity.Company;
import com.fsd.stock.company.repository.CompanyRepository;


@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	public void delete(Long id) {
//		companyRepository.delete(company);
		companyRepository.deleteById(id);
	}

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Company findById(Long id) {
		Optional<Company> result = companyRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

}
