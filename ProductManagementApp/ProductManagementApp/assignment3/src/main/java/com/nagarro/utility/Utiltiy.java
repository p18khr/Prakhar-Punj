package com.nagarro.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.nagarro.model.Product;
import com.nagarro.model.User;

public class Utiltiy {
	public static Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class)
			.addAnnotatedClass(Product.class);
	public static SessionFactory sessionFactory = configuration.buildSessionFactory();;
}
