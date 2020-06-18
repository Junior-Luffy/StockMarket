package com.fsd.stock.attachment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.stock.attachment.entity.StockPrice;

public interface AttachmentRepository extends JpaRepository<StockPrice, Long> {

}
