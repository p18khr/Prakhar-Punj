package com.training.nagarro.ecommerce2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.nagarro.ecommerce2.model.Product;
import com.training.nagarro.ecommerce2.service.ProductService;

@CrossOrigin("http://localhost:4200")
@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/product")
	public List<Product> getProducts(){
		return this.service.getProductList();
	}
	
	@GetMapping("/product-list/{id}")
	public List<Product> getList(@PathVariable long id){
		return this.service.getList(id);
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable long id) {
		return this.service.getProduct(id);
	}
	
	@PostMapping("/product/{id}")
	public Product postProduct(@PathVariable long id,@RequestBody Product product) {
		return this.service.add(product, id);
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.PUT)
	public void updateProduct(@RequestBody Product product,@PathVariable long id) {
		 this.service.update(product,id);
	}
	
	@RequestMapping(value="/delete-product/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		this.service.delete(id);
	}
	
	@PostMapping(value="/update-stock/{id}")
	public void update(@RequestBody Product product,@PathVariable long id) {
		this.service.updateStocks(product.getStock(),id);
		}
	
	@GetMapping(value="search-product/{name}")
	public List<Product> search(@PathVariable String name) {
		return this.service.searchProduct(name);
	}
	
	@GetMapping(value="search-brand-category/{Brand}/{Category}")
	public List<Product> searchBrandCategory(@PathVariable String Brand,@PathVariable String Category) {
		return this.service.search(Brand,Category);
	}
	
	
	@GetMapping("/product-brand")
	public List<String> brand(){
		return this.service.getBrand();
	}
	
	@GetMapping("/product-category")
	public List<String> category(){
		return this.service.getCategory();
	}
}

