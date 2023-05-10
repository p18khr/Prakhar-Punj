package com.training.nagarro.ecommerce2.model;

import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,length=25,unique=true)
	private String name;
	
	@Column(nullable=false,length=20)
	private String category;
	
	@Column(nullable=false,length=20)
	private String brand;
	
	@Column(nullable=false,length=6)
	private Double price;
	
	@Column(nullable=false,length=2)
	private int discount;
	
	@Column(nullable=false)
	private int stock;
	
	
	@Column(nullable=false)
	private String image;
	
	@Column(nullable=false)
	private Long vendorId;

	public Product(Long id, String name, String category, String brand, Double price, String image, Long vendorId) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.image = image;
		this.vendorId = vendorId;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getVendor() {
		return vendorId;
	}

	public void setVendor(Long vendorId) {
		this.vendorId = vendorId;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", brand=" + brand + ", price="
				+ price + ", image=" + image + ", vendor=" + vendorId + "]";
	}
	
	
}
