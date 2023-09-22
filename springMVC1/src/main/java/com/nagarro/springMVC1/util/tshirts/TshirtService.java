package com.nagarro.springMVC1.util.tshirts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.springMVC1.model.Tshirt;
import com.nagarro.springMVC1.util.hibernate.HibernateUtil;

public class TshirtService {

	static ArrayList<Tshirt> matchT = new ArrayList<Tshirt>();

	public static void displayTees(List<Tshirt> list) {
		if (list.isEmpty()) {
			System.out.println("-----------NO AVAILABLE TSHIRTS------------");
			return;
		}
		for (Tshirt t : list) {
			t.printDetails();
		}
	}

	public static ArrayList<Tshirt> findTshirts(String _colour, String _size, String _gender, String pref) {
		System.out.println("-----------Finding Tshirts------------");

		String hql = "from Tshirt where colour=:colour and size=:size and gender=:gender and availability=:y";

		Session session = HibernateUtil.getTshirtSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery(hql);
		
		query.setParameter("colour", _colour.toLowerCase());
		query.setParameter("size", _size.toLowerCase());
		query.setParameter("gender", _gender.toLowerCase());
		query.setParameter("y", "y");

		matchT = (ArrayList<Tshirt>) query.getResultList();

		tx.commit();
		session.close();
		if (pref.equals("p")) {
			Collections.sort(matchT, (i, j) -> i.getPrice() > j.getPrice() ? 1 : -1);
		} else if (pref.equals("r")) {
			Collections.sort(matchT, (i, j) -> i.getRating() > j.getRating() ? -1 : 1);
		} else {
			Collections.sort(matchT, (i, j) -> i.getRating() > j.getRating() ? -1 : 1);
			Collections.sort(matchT, (i, j) -> i.getPrice() > j.getPrice() ? 1 : -1);
		}
		displayTees(matchT);
		return matchT;

	}
}
