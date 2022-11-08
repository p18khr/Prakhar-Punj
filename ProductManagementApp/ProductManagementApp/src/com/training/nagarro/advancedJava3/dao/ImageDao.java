package com.training.nagarro.advancedJava3.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import javax.servlet.http.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.training.nagarro.advancedJava3.model.Product;
import com.training.nagarro.advancedJava3.model.User;

public class ImageDao {
	public static Configuration configuration = new Configuration().configure("/resources/hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Product.class);
	public static SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	public void insertProduct(Part part, Product productObj) throws IOException {
		InputStream inputStream = null;
		if (part != null) {
			inputStream = part.getInputStream();
			if (inputStream != null) {
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				byte[] imageBytes = inputStream.readAllBytes();
				productObj.setImage(imageBytes);
				session.saveOrUpdate(productObj);
				tx.commit();
				session.close();

			}
		}
	}
}
