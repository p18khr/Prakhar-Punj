package com.training.nagarro.ecommerce2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.nagarro.ecommerce2.model.User;

public interface RegisterUserService {

	 List<User> getList();

	User add(User user);

	void delete(Long id);
	
	List<User> list();
}
