package com.nagarro.advanceJava2.functionality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import com.nagarro.advanceJava2.model.Tshirt;
import com.nagarro.advanceJava2.repository.HibernateUtil;

public class Model {

	static ArrayList<Tshirt> matchT = new ArrayList<Tshirt>();

	public static void displayTees(List<Tshirt> list) {
		if (list.isEmpty()) {
			System.out.println("NO AVAILABLE TSHIRTS");
			return;
		}
		for (Tshirt t : list) {
			t.printDetails();
		}
	}

	public static void findTshirts(String _colour, String _size, String _gender, String pref) {

		HibernateUtil hUtil = new HibernateUtil();
		String hql = "from Tshirt where colour=:colour and size=:size and gender=:gender";


		Session s = hUtil.sf.openSession();
		s.beginTransaction();
		
		SelectionQuery query = s.createSelectionQuery(hql);
		query.setParameter("colour", _colour);
		query.setParameter("size", _size);
		query.setParameter("gender", _gender);
		
		matchT = (ArrayList<Tshirt>)query.getResultList();
		
		s.close();
		
		if (pref.equals("p")) {
			Collections.sort(matchT, (i, j) -> i.getPrice() > j.getPrice() ? 1 : -1);
		} else if (pref.equals("r")) {
			Collections.sort(matchT, (i, j) -> i.getRating() > j.getRating() ? -1 : 1);
		} else {
			Collections.sort(matchT, (i, j) -> i.getRating() > j.getRating() ? -1 : 1);
			Collections.sort(matchT, (i, j) -> i.getPrice() > j.getPrice() ? 1 : -1);
		}
		displayTees(matchT);
		
		
	}
}
