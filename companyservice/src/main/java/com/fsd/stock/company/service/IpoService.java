package com.fsd.stock.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.company.entity.Ipo;
import com.fsd.stock.company.repository.IpoRepository;


@Service
public class IpoService {
	@Autowired
	private IpoRepository ipoRepository;
	
	public Ipo save(Ipo ipo) {
		return ipoRepository.save(ipo);
	}

	public void delete(Long id) {
		ipoRepository.deleteById(id);
	}

	public List<Ipo> findAll() {
		return ipoRepository.findAll();
	}

	public Ipo findById(Long id) {
		Optional<Ipo> result = ipoRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

}
