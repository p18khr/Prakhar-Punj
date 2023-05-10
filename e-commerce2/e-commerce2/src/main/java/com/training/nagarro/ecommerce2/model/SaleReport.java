package com.training.nagarro.ecommerce2.model;


public class SaleReport {

	
	private int quantity;
	private String brand;
	private String category;
	private String name;
	private Long price;
	private Long vendorId;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public SaleReport(int quantity, String brand, String category, String name, Long price, Long vendorId) {
		super();
		this.quantity = quantity;
		this.brand = brand;
		this.category = category;
		this.name = name;
		this.price = price;
		this.vendorId = vendorId;
	}
	public SaleReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
