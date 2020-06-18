package com.fsd.stock.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.stock.company.entity.StockExchange;


public interface StockExchangeRepository extends JpaRepository<StockExchange, Long>{

}
