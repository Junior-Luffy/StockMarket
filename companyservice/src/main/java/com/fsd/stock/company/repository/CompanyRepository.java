package com.fsd.stock.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.stock.company.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
