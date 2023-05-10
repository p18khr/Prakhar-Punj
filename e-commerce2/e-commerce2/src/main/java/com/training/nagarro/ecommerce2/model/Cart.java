package com.training.nagarro.ecommerce2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private Long productId;
	
	@Column(nullable=false,length=25)
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
	private int quantity=1;
	
	@Column(nullable=false)
	private Long userId;
	
	
	@Column(nullable=false)
	private int stock;
	
	@Column(nullable=false)
	private String image;
	
	@Column(nullable=false)
	private Double totalPrice;
	
	
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Long id, Long productId, String name, String category, String brand, Double price, int discount,
			int quantity, Long userId, int stock, String image, Double totalPrice) {
		super();
		this.id = id;
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.userId = userId;
		this.stock = stock;
		this.image = image;
		this.totalPrice = totalPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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



	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", productId=" + productId + ", name=" + name + ", category=" + category + ", brand="
				+ brand + ", price=" + price + ", discount=" + discount + ", quantity=" + quantity + ", userId="
				+ userId + ", stock=" + stock + ", image=" + image + ", totalPrice=" + totalPrice + "]";
	}



	
	
	
}
