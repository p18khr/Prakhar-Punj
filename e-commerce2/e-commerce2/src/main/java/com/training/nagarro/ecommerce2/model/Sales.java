package com.training.nagarro.ecommerce2.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="sales")
public class Sales {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private Long productId;
	
	@Column(nullable=false)
	private Long userId;
	
	@Column(nullable=false)
	private int quantity;

	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Double price;
	
	@Column(nullable=false)
	private String brand;
	
	@Column(nullable=false)
	private String category;
	
	@Column(nullable=false)
	private String image;
	
	@Column(nullable=false)
	private Double totalPrice;
	
	@Column(nullable=false,length=2)
	private int discount;
	
	@Column(nullable=false)
	private Long vendorId;
	
	@Column(nullable=false)
	private String OrderDate;
	
	@Column(nullable=false)
	private String OrderTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate() {
		OrderDate = String.valueOf(LocalDate.now());
	}

	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(){
		OrderTime = String.valueOf(LocalTime.now());
		OrderTime = OrderTime.substring(0,8);
	}

	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sales(Long id, Long productId, Long userId, int quantity, String name, Double price, String brand,
			String category, String image, Double totalPrice, int discount, Long vendorId, String orderDate,
			String orderTime) {
		super();
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.category = category;
		this.image = image;
		this.totalPrice = totalPrice;
		this.discount = discount;
		this.vendorId = vendorId;
		OrderDate = orderDate;
		OrderTime = orderTime;
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", productId=" + productId + ", userId=" + userId + ", quantity=" + quantity
				+ ", name=" + name + ", price=" + price + ", brand=" + brand + ", category=" + category + ", image="
				+ image + ", totalPrice=" + totalPrice + ", discount=" + discount + ", vendorId=" + vendorId
				+ ", OrderDate=" + OrderDate + ", OrderTime=" + OrderTime + "]";
	}

	
	



		
	
}
