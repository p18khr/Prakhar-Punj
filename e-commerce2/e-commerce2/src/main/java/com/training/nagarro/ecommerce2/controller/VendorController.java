package com.training.nagarro.ecommerce2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.nagarro.ecommerce2.model.Vendor;
import com.training.nagarro.ecommerce2.service.RegisterVendorService;

@CrossOrigin("http://localhost:4200")
@RestController
public class VendorController {

	
	@Autowired
	RegisterVendorService service;
	
	@PostMapping("/register-vendor")
	public Vendor addVendor(@RequestBody Vendor vendor) {
		return this.service.add(vendor);
	}
	
	@GetMapping("/vendor-login")
	public List<Vendor> getVendor() {
		return this.service.getList();
	}
}
