package com.training.nagarro.ecommerce2.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.nagarro.ecommerce2.dao.CartRepository;
import com.training.nagarro.ecommerce2.dao.ProductRepository;
import com.training.nagarro.ecommerce2.model.Product;
import com.training.nagarro.ecommerce2.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	List<Product> list;
	
	ProductRepository repo;
	CartRepository repoCart;
	
	@Autowired
	public ProductServiceImpl(ProductRepository repo,CartRepository repoCart) {
		this.repo = repo;
		this.repoCart=repoCart;
	}
	
	public ProductServiceImpl() {}
	
	public List<Product> getProductList(){
		list = this.repo.findAll();
		
		return list;
	}


	public Product add(Product product,long id) {
		product.setVendor(id);
		this.repo.save(product);
		return product;
	}


	public void update(Product product,long id) {
        this.repo.updateQuery(product.getStock(),product.getPrice(),product.getDiscount(),id); 
	}


	public Product getProduct(long id) {
		Product p = this.repo.find(id);
		return p;
	}


	public void delete(long id) {
		this.repo.deleteById(id);
	}

	
	public List<Product> getList(long idvendor) {
		List<Product> listnew = this.repo.findVendorProduct(idvendor);
		return listnew;
	}

	public void updateStocks(int stock, long id) {
		this.repo.updateStock(stock,id);
		this.repoCart.upDate(stock,id);
	}

	public List<Product> searchProduct(String name) {
		List<Product> list = this.repo.searchByKey(name);
		return list;
	}

	public List<String> getCategory() {
		List<String> list = this.repo.category();
		return list;
	}

	public List<String> getBrand() {
		List<String> list = this.repo.brand();
		return list;
	}

	public List<Product> search(String brand,String category) {
		List<Product> list = this.repo.search2(brand,category);
		return list;
	}
	
	
}
