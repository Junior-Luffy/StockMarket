package com.fsd.stock.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockexchange")
public class StockExchange {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "stock_exchange")
    private String stockexchange;
	
	@Column(name = "brief")
    private String brief;

	
	@Column(name = "contact_address")
    private String contactaddress;

	
	@Column(name = "remark")
    private String remark;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStockexchange() {
		return stockexchange;
	}


	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}


	public String getBrief() {
		return brief;
	}


	public void setBrief(String brief) {
		this.brief = brief;
	}


	public String getContactaddress() {
		return contactaddress;
	}


	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

}
