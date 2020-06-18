package com.fsd.stock.sector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.sector.entity.Sector;
import com.fsd.stock.sector.service.SectorService;

@RestController
public class SectorController {
	@Autowired
	private SectorService sectorService;
	
	@GetMapping("/sector")
	public List<Sector> getAll(){
		return sectorService.findAll();
	}
	
	@GetMapping("/sector/{id}")
	public Sector getById(@PathVariable Long id) {
		return sectorService.findById(id);
	}
	
	@PostMapping("/sector/save")
	public Sector save(@RequestBody Sector sector) {
		return sectorService.save(sector);
	}
	
	@DeleteMapping("/sector/{id}")
	public void deleteById(@PathVariable Long id) {
		sectorService.delete(id);
	}

}
