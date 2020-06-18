package com.fsd.stock.company.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fsd.stock.company.entity.StockPrice;
import com.fsd.stock.company.model.SearchCondition;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
	@Query(value = "SELECT s.id, s.company_code companycode, DATE_FORMAT(s.date,'%Y-%m-%d %H:%i:%s') `date`, s.price, s.stock_exchange stockexchange, c.company_name companyname "
			+ "FROM myfsd.stockprice s left join myfsd.company c on s.company_code = c.company_code "
			+ "where c.company_name= :#{#input.companyname} and s.stock_exchange = :#{#input.stockexchange} and s.date>=:#{#input.starttime} and s.date<=:#{#input.endtime} "
			+ "order by s.date", nativeQuery = true)
	List<Map<String, Object>> getStockPrice(@Param("input") SearchCondition searchCondition);
}
