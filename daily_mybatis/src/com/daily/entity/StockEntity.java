package com.daily.entity;

public class StockEntity {
	/**
	 * `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `STOCK_NAME` varchar(20) NOT NULL DEFAULT '""' COMMENT '股票名称',
  `STOCK_NO` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '股票代码',
  `COMPANY_NAME` varchar(50) NOT NULL DEFAULT '""' COMMENT '公司全名',
  `STOCK_PRICE` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '股票价格',
	 */
	private int id;
	private String stock_name;
	private int stock_no;
	private String company_name;
	private double stock_price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public int getStock_no() {
		return stock_no;
	}
	public void setStock_no(int stock_no) {
		this.stock_no = stock_no;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public double getStock_price() {
		return stock_price;
	}
	public void setStock_price(double stock_price) {
		this.stock_price = stock_price;
	}
	
	

}
