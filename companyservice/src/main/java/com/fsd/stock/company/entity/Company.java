package com.fsd.stock.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "company_name")
	private String companyname;
	
	@Column(name = "company_code")
	private String companycode;
	
	@Column(name = "turnover")
	private String turnover;
	
	@Column(name = "ceo")
	private String ceo;
	
	@Column(name = "board_directors")
	private String boarddirectors;
	
	@Column(name = "stock_exchange_code")
	private String stockexchangecode;
	
	@Column(name = "sector")
	private String sector;
	
	@Column(name = "brief")
	private String brief;
	
	@Column(name = "stock_code")
	private String stockcode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoarddirectors() {
		return boarddirectors;
	}

	public void setBoarddirectors(String boarddirectors) {
		this.boarddirectors = boarddirectors;
	}

	public String getStockexchangecode() {
		return stockexchangecode;
	}

	public void setStockexchangecode(String stockexchangecode) {
		this.stockexchangecode = stockexchangecode;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getStockcode() {
		return stockcode;
	}

	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}
}
