package com.fsd.stock.sector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.sector.entity.Sector;
import com.fsd.stock.sector.repository.SectorRepository;

@Service
public class SectorService {
	@Autowired
	private SectorRepository sectorRepository;
	
	public Sector save(Sector sector) {
		return sectorRepository.save(sector);
	}

	public void delete(Long id) {
		sectorRepository.deleteById(id);
	}

	public List<Sector> findAll() {
		return sectorRepository.findAll();
	}

	public Sector findById(Long id) {
		Optional<Sector> result = sectorRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

}
