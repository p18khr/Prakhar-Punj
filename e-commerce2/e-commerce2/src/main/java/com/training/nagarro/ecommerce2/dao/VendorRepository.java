package com.training.nagarro.ecommerce2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.nagarro.ecommerce2.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Long> {

	Vendor findByEmail(String email);
}
