package com.fsd.stock.company.model;

public class SearchCondition {
	
	private String[] companynames;
	
	private String companyname;
	
	private String stockexchange;
	
	private String starttime;
	
	private String endtime;
	
	private String specifytime;

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}

	public String[] getCompanynames() {
		return companynames;
	}

	public void setCompanynames(String[] companynames) {
		this.companynames = companynames;
	}

	public String getSpecifytime() {
		return specifytime;
	}

	public void setSpecifytime(String specifytime) {
		this.specifytime = specifytime;
	}

}
