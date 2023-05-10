package com.training.nagarro.ecommerce2.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false , unique=true, length=45)
	private String email;
	
	@Column(nullable=false,length=64)
	private String password;
	
	@Column(nullable=false,length=20)
	private String FirstName;
	
	@Column(nullable=false,length=20)
	private String LastName;
	
	@Column(nullable=false,length=40)
	private String Address;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String password, String email, String firstName, String lastName, String address) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", email=" + email + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", Address=" + Address + "]";
	}
	
}
