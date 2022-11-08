package com.training.nagarro.advancedJava3.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.training.nagarro.advancedJava3.model.Product;
import com.training.nagarro.advancedJava3.model.User;

public class LoginValidation{
	public static Configuration configuration = new Configuration().configure("/resources/hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Product.class);
	public static SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	public boolean checkUser(User userObj) {
		
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from User where userName = :username and password = :password");
			query.setParameter("username", userObj.getUserName());
			query.setParameter("password", userObj.getPassword());
			User data = (User) query.uniqueResult();
			tx.commit();
			session.close();
			if (data == null) {
				System.out.println("null");
				return false;
			} else if (data.getPassword().equals(userObj.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
		catch(Throwable e) {
			System.out.print(e);
		}
		return false;
}
}