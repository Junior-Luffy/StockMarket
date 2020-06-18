package com.fsd.stock.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.stock.company.entity.Ipo;

public interface IpoRepository extends JpaRepository<Ipo, Long> {

}
