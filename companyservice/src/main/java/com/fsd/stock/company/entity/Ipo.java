package com.fsd.stock.company.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ipo")
public class Ipo {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "company_name")
	private String companyname;
	
	@Column(name = "company_code")
	private String companycode;
	
	@Column(name = "stock_exchange")
	private String stockexchange;
	
	@Column(name = "price_pershare")
	private Double pricepershare;
	
	@Column(name = "total_share_number")
	private Long totalnumber;
	
	@Column(name = "open_date_time")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date opendatetime;

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

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}

	public Double getPricepershare() {
		return pricepershare;
	}

	public void setPricepershare(Double pricepershare) {
		this.pricepershare = pricepershare;
	}

	public Long getTotalnumber() {
		return totalnumber;
	}

	public void setTotalnumber(Long totalnumber) {
		this.totalnumber = totalnumber;
	}

	public Date getOpendatetime() {
		return opendatetime;
	}

	public void setOpendatetime(Date opendatetime) {
		this.opendatetime = opendatetime;
	}
}
