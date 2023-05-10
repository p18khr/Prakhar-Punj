package com.training.nagarro.ecommerce2.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.nagarro.ecommerce2.dao.UserRepository;
import com.training.nagarro.ecommerce2.model.User;
import com.training.nagarro.ecommerce2.service.RegisterUserService;


@Service("registerUserService")
@Transactional
public class RegisterUserServiceImpl implements RegisterUserService {

	
	List<User> list = new ArrayList<>();
	
	
	UserRepository userRepository;
	
	
	@Autowired
	public RegisterUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;	
    }
	
	public RegisterUserServiceImpl() {}
	
	public List<User> getList() {
		
	    list = this.userRepository.findAll();
		return list;
		
	}
	
	
	

	
	public User add(User user) {
		this.userRepository.save(user);
		return user;
	}


	public void delete(Long id) {
		this.userRepository.deleteById(id);
		
	}


	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return list;
	}


}
