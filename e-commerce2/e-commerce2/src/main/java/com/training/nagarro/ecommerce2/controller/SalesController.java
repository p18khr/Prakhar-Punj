package com.training.nagarro.ecommerce2.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.nagarro.ecommerce2.model.Product;
import com.training.nagarro.ecommerce2.model.SaleReport;
import com.training.nagarro.ecommerce2.model.Sales;
import com.training.nagarro.ecommerce2.service.CartService;
import com.training.nagarro.ecommerce2.service.SalesService;

@CrossOrigin("http://localhost:4200")
@RestController
public class SalesController {

	@Autowired
	SalesService service;
	
	
	
	@GetMapping("/get-sales")
	public List<Sales> getSales() {
		return this.service.get();
	}
	
	@GetMapping("/get-orders/{iduser}")
	public List<Sales> getOrders(@PathVariable long iduser){
		return this.service.getUserOrders(iduser);
	}
	
	@PostMapping("/sales")
	public void sellProduct(@RequestBody Sales s) {
	 this.service.sale(s);
	}
	
	@GetMapping("/latest-sales-order/{iduser}")
	public Sales getOrder(@PathVariable long iduser) {
		return this.service.getLatest(iduser);
	}
	
	@GetMapping("/get-date/{idvendor}/{startDate}/{endDate}")
	public List<Sales> filter(@PathVariable String startDate,@PathVariable String endDate,@PathVariable long idvendor){
		return this.service.filterDate(startDate,endDate,idvendor);
	}
	
	@GetMapping("/sales-category")
	public List<String> category(){
		return this.service.getCategory();
	}
	
	@GetMapping("/sales-brand")
	public List<String> brand(){
		return this.service.getBrand();
	}
	
	@GetMapping(value="search-sales/{name}")
	public List<Sales> search(@PathVariable String name) {
		return this.service.searchProduct(name);
	}
	
	@GetMapping(value="sales-brand-category/{Brand}/{Category}")
	public List<Sales> searchBrandCategory(@PathVariable String Brand,@PathVariable String Category) {
		return this.service.search(Brand,Category);
	}
	
	@GetMapping(value="/latest-orders/{iduser}/{count}") 
	public List<Sales> getLatestOrders(@PathVariable long iduser,@PathVariable int count){
		return this.service.getLatestOnes(iduser,count);
	}
}

