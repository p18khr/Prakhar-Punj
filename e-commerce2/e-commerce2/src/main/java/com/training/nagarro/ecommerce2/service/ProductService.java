package com.training.nagarro.ecommerce2.service;

import java.util.List;

import com.training.nagarro.ecommerce2.model.Product;


public interface ProductService {

	List<Product> getProductList();
	
	Product add(Product product, long id);

	void update(Product product, long id);

	Product getProduct(long id);

	void delete(long id);

	List<Product> getList(long idvendor);

	void updateStocks(int stock, long id);

	List<Product> searchProduct(String name);

	
	List<String> getBrand();
	
	List<String> getCategory();

	List<Product> search(String brand, String category);
}
