package com.training.nagarro.ecommerce2.service;

import java.util.List;

import com.training.nagarro.ecommerce2.model.Cart;

public interface CartService {

	Cart add(Cart cart, long id1, long id12);

	List<Cart> cartList(long id);

	void delete(Long id);

	void update(int quantity, long idcart);

	List<Cart> checkingOut(long iduser);

	void emptyCart(Long iduser);

	int count(Long iduser);

}
