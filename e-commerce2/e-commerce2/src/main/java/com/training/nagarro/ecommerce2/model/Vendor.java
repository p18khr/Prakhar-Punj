package com.training.nagarro.ecommerce2.model;

import javax.persistence.*;

@Entity
@Table(name="vendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,length=25)
	private String name;
	
	@Column(nullable=false,unique=true,length=45)
	private String email;
	
	@Column(nullable=false,length=64)
	private String password;
	
	@Column(nullable=false,length=10)
	private Long contactNo;

	public Vendor(Long id, String name, String email, String password, Long contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
	}

	public Vendor() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", contactNo="
				+ contactNo + "]";
	}
	
	
	
}
