package com.training.nagarro.ecommerce2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.training.nagarro.ecommerce2.dao.UserRepository;
import com.training.nagarro.ecommerce2.model.*;
import com.training.nagarro.ecommerce2.service.RegisterUserService;
import com.training.nagarro.ecommerce2.serviceimpl.RegisterUserServiceImpl;

@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private RegisterUserService userservice;
	
    
    @GetMapping("/login")
    public List<User> getUsers(){
		return this.userservice.getList();
    }
    
    
    @PostMapping("/user-register")
    public User addUser(@RequestBody User user) {
    	return this.userservice.add(user);
    }
    
    
    @PutMapping("")
    
    @RequestMapping(value = "/delete",method=RequestMethod.DELETE)
    public void deleteUser(@RequestBody User user) {
    	this.userservice.delete(user.getId());
    }
}
