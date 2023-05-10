package com.training.nagarro.ecommerce2.service;


import java.util.List;

import com.training.nagarro.ecommerce2.model.Vendor;

public interface RegisterVendorService {

	Vendor add(Vendor vendor);

	List<Vendor> getList();

}
