package com.training.nagarro.ecommerce2.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.nagarro.ecommerce2.dao.CartRepository;
import com.training.nagarro.ecommerce2.model.Cart;
import com.training.nagarro.ecommerce2.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	List<Cart> list = new ArrayList<>();
	
	
	CartRepository repo;
	
	@Autowired
	public CartServiceImpl(CartRepository repo) {
		this.repo=repo;
	}
	
	public CartServiceImpl() {}
	
	public Cart add(Cart cart,long iduser, long idproduct) {
		List<Cart> list = this.repo.findAll();
		boolean b=false;
		for(Cart c:list) {
			if(c.getUserId()==iduser && c.getProductId()==idproduct) {
				b = true;
			}
		}
		if(b == false) {
			cart.setProductId(idproduct);
			cart.setUserId(iduser);
			cart.setTotalPrice(cart.getPrice()-(cart.getPrice()*cart.getDiscount())/100);
			this.repo.save(cart);
		}
		return cart;
	}


	public List<Cart> cartList(long id) {
		list = this.repo.find(id);
		return list;
	}

	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}

	public void update(int quantity,long idcart) {
	    this.repo.update(quantity,idcart);	
	}

	public List<Cart> checkingOut(long iduser) {
		List<Cart> list = this.repo.check(iduser);
		return list;
	}

	public void emptyCart(Long iduser) {
		this.repo.deleteUserId(iduser);
	}

	public int count(Long iduser) {
		int count = this.repo.getCount(iduser);
		return count;
	}

	

	
}
