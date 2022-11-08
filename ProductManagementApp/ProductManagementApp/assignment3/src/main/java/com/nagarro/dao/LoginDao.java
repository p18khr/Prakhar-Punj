package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.nagarro.model.Product;
import com.nagarro.model.User;
import com.nagarro.utility.Utiltiy;

public class LoginDao {
	public boolean checkUser(User userObj) {

		Session session = Utiltiy.sessionFactory.openSession();
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
}
