package com.training.nagarro.ecommerce2.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.nagarro.ecommerce2.dao.VendorRepository;
import com.training.nagarro.ecommerce2.model.Vendor;
import com.training.nagarro.ecommerce2.service.RegisterVendorService;

@Service
@Transactional
public class RegisterVendorServiceImpl implements RegisterVendorService {

	VendorRepository repo;
	List<Vendor> list = new ArrayList<>();
	
	
	@Autowired
	public RegisterVendorServiceImpl(VendorRepository repo) {
		this.repo = repo;
	}

	public RegisterVendorServiceImpl() {}
		


	public Vendor add(Vendor vendor) {
		this.repo.save(vendor);
		
		return vendor;
	}




	public List<Vendor> getList() {
		list = this.repo.findAll();
		return list;
	}

	
	
}
