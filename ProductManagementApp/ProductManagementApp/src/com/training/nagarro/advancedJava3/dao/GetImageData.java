package com.training.nagarro.advancedJava3.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.training.nagarro.advancedJava3.model.Product;
import com.training.nagarro.advancedJava3.model.User;


public class GetImageData {
	public static Configuration configuration = new Configuration().configure("/resources/hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Product.class);
	public static SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	public static List<Product> ProductList = new ArrayList<Product>();

	public static List<Product> getImageDatas() {
	
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("from Product");
		ProductList = q.list();
		tx.commit();
		session.close();

		return ProductList;
	}

}
