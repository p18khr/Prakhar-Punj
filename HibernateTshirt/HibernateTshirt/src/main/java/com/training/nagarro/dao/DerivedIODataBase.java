package com.training.nagarro.dao;

import java.util.List;
import com.training.nagarro.models.Tshirt;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DerivedIODataBase implements IODataBase{

	private Configuration configuration = new Configuration().configure().addAnnotatedClass(Tshirt.class);
	private SessionFactory sessionFactory = configuration.buildSessionFactory();

	@Override
	public void insertIntoDatabase(Tshirt tshirtObj) {
		Session session =  sessionFactory.openSession();
		Transaction tx = session.beginTransaction();  // inserts Tshirt object in the database
		session.saveOrUpdate(tshirtObj);
		tx.commit();
	}


	@Override      // retrieves data from the database
        public void getData(String preference,String color,String gender,String size){

			DerivedReadCsvFiles rcsv = new DerivedReadCsvFiles();
			rcsv.storeCsvData();
		Session session =  sessionFactory.openSession();
			String sortBy = "";
			if(preference.equalsIgnoreCase("price")){
				sortBy = "price asc";
			}
			else if(preference.equalsIgnoreCase("rating")){
				sortBy = "rating desc";
			}
			else if (preference.equalsIgnoreCase("Ratingandprice")||
					preference.equalsIgnoreCase("ratingprice")||
					preference.equalsIgnoreCase("priceandrating")||
					preference.equalsIgnoreCase("pricerating")){
				sortBy = "price asc rating desc";
			}

			session.beginTransaction();
			Query query = session.createQuery("from Tshirt where colour = :color and size = :size and gender = :gender ORDER BY "+ sortBy);
			query.setParameter("color",color);
			query.setParameter("size", size);
			query.setParameter("gender",  gender);
			
			List<Tshirt> result = query.list();

			if(result.size() == 0){
				System.out.println("No matches");
				return;
			}
			session.getTransaction().commit();
             viewData(result);
        }

		@Override     // prints data
		public void viewData(List<Tshirt> t){
			System.out.println("ID|NAME|COLOUR|GENDER_RECOMMENDATION|SIZE|PRICE|RATING|AVAILABILITY");

			for(int i=0;i<t.size();i++){
				System.out.println(t.get(i).getId()+"|"+t.get(i).getName()+"|"+t.get(i).getColour()+"|"+
						t.get(i).getGender()+"|"+t.get(i).getSize()+"|"+t.get(i).getPrice()+"|"+
						t.get(i).getRating()+"|"+t.get(i).getAvailability());
			}

		}
        

}

