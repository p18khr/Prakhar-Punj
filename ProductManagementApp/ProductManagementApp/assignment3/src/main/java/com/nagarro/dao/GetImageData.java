package com.nagarro.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.model.Product;
import com.nagarro.model.User;
import com.nagarro.utility.Utiltiy;

public class GetImageData {

	public static List<Product> ProductList = new ArrayList<Product>();

	public static List<Product> getImageDatas() {
	
		Session session = Utiltiy.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("from Product");
		ProductList = q.list();
		tx.commit();
		session.close();

		return ProductList;
	}

}
