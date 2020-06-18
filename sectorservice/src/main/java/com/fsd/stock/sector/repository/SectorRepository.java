package com.fsd.stock.sector.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.stock.sector.entity.Sector;

public interface SectorRepository extends JpaRepository<Sector, Long> {

}
