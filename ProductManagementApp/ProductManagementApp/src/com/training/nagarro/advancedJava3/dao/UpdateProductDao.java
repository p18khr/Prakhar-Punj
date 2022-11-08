package com.training.nagarro.advancedJava3.dao;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.training.nagarro.advancedJava3.model.Product;
import com.training.nagarro.advancedJava3.model.User;

public class UpdateProductDao {
	
	public static Configuration configuration = new Configuration().configure("/resources/hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Product.class);
	public static SessionFactory sessionFactory = configuration.buildSessionFactory();
	

	public void updateProduct(Part part, Product productObj) throws IOException {
		InputStream inputStream = null;

		if (part != null) {
			inputStream = part.getInputStream();

			if (inputStream != null) {
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				byte[] imageBytes = inputStream.readAllBytes();
				productObj.setImage(imageBytes);
				Query query = session.createQuery(
						"update Product p set p.title=:title, p.size=:size ,p.quantity=:quantity,p.image =:image where  id= :id");

				query.setParameter("id", productObj.getId());
				query.setParameter("title", productObj.getTitle());
				query.setParameter("size", productObj.getSize());
				query.setParameter("quantity", productObj.getQuantity());
				query.setParameter("image", productObj.getImage());
				tx.commit();
				session.close();

			}
		}
	}

	public void deleteProductData(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Product where  id =:id");
		query.setParameter("id",Integer.parseInt(id));
		query.executeUpdate();
		tx.commit();
		session.close();
	}

}
