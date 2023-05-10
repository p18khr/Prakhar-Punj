package com.training.nagarro.ecommerce2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.nagarro.ecommerce2.model.Cart;
import com.training.nagarro.ecommerce2.model.Count;
import com.training.nagarro.ecommerce2.model.Product;
import com.training.nagarro.ecommerce2.model.Sales;
import com.training.nagarro.ecommerce2.service.CartService;
import com.training.nagarro.ecommerce2.service.ProductService;
import com.training.nagarro.ecommerce2.service.SalesService;

@CrossOrigin("http://localhost:4200")
@RestController
public class CartController {

	@Autowired
	CartService service;
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	SalesService sservice;
	
	@PostMapping("/add-cart/{iduser}/{idproduct}")
	public Cart addToCart(@RequestBody Cart cart,@PathVariable long iduser,@PathVariable long idproduct) {
		return this.service.add(cart,iduser, idproduct);
	}
	
	@PutMapping("/update-quantity/{idcart}")
	public void updateQuantity(@RequestBody Cart cart,@PathVariable Long idcart){
		this.service.update(cart.getQuantity(),idcart);
	}
	
	@GetMapping("/get-cart/{id}")
	public List<Cart> getList(@PathVariable long id){
		return this.service.cartList(id);
	}
	
	@GetMapping("/get-count/{iduser}")
	public Count getCount(@PathVariable Long iduser) {
		int count = this.service.count(iduser);
		Count c = new Count(count);
		
		return c;
	}
	
	@RequestMapping(value="/delete-cart/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		this.service.delete(id);
	}
	
	@DeleteMapping(value="/delete/{iduser}")
	public void empty(@PathVariable Long iduser) {
		this.service.emptyCart(iduser);
	}
	
	@GetMapping("/checkout/{iduser}")
	public void checkout(@PathVariable long iduser) {
		List<Cart> list = this.service.checkingOut(iduser);
		
		List<Product> l = this.pservice.getProductList();
		
		for(Cart c:list) {
			Sales s = new Sales();
			s.setBrand(c.getBrand());
			s.setCategory(c.getCategory());
			s.setName(c.getName());
			s.setDiscount(c.getDiscount());
			s.setImage(c.getImage());
			s.setPrice(c.getPrice());
			s.setProductId(c.getProductId());
			s.setQuantity(c.getQuantity());
			s.setUserId(c.getUserId());
			
			long id = 0;
			for(Product p:l) {
				if(p.getId() == c.getProductId()) {
					id = p.getVendor();
				}
			}
			s.setVendorId(id);
			
			this.sservice.sale(s);
			this.pservice.updateStocks(c.getQuantity(), c.getProductId());
		}
	}
}
