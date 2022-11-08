package com.nagarro.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.http.Part;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nagarro.model.Product;
import com.nagarro.utility.Utiltiy;

public class ImageDao {
	public void insertProduct(Part part, Product productObj) throws IOException {
		InputStream inputStream = null;
		if (part != null) {
			inputStream = part.getInputStream();
			if (inputStream != null) {
				Session session = Utiltiy.sessionFactory.openSession();
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
