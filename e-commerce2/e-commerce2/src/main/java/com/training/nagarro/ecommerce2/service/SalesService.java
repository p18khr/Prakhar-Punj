package com.training.nagarro.ecommerce2.service;

import java.time.LocalDate;
import java.util.List;

import com.training.nagarro.ecommerce2.model.Product;
import com.training.nagarro.ecommerce2.model.SaleReport;
import com.training.nagarro.ecommerce2.model.Sales;

public interface SalesService {

	void sale(Sales s);

	List<Sales> get();

	Sales getLatest(long iduser);

	List<Sales> getUserOrders(long iduser);

	
	List<Sales> filterDate(String startDate, String endDate, long idvendor);

	List<String> getCategory();

	List<String> getBrand();

	List<Sales> searchProduct(String name);

	List<Sales> search(String brand, String category);

	List<Sales> getLatestOnes(long iduser, int count);
	
}
