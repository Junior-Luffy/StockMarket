package com.fsd.stock.attachment.entity;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fsd.stock.attachment.util.ExcelUtility;

@Entity
@Table(name="stockprice")
public class StockPrice {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "company_code")
    private String companycode;

	@Column(name = "stock_exchange")
    private String stockexchange;

	@Column(name = "price")
    private Double price;

	@Column(name = "date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;
	
	@Transient
	private String datestr;
	
	@Transient
	private String pricestr;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPricestr() {
		return pricestr;
	}

	public void setPricestr(String pricestr) {
		this.pricestr = pricestr;
		this.price = Double.parseDouble(pricestr);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDatestr() {
		return datestr;
	}

	public void setDatestr(String datestr) {
		this.datestr = datestr;
		try {
			setDate(ExcelUtility.dateFormat.parse(datestr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}