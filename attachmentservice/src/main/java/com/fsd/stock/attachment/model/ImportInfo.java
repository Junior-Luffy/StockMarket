package com.fsd.stock.attachment.model;

public class ImportInfo {
	private String companycode;

	private String stockexchange;

	private int totalnumbers;

	private String starttime;

	private String endtime;

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

	public int getTotalnumbers() {
		return totalnumbers;
	}

	public void setTotalnumbers(int totalnumbers) {
		this.totalnumbers = totalnumbers;
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

}
