package com.training.nagarro.ecommerce2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.nagarro.ecommerce2.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
