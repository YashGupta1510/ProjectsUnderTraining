package com.nagarro.forget;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.nagarro.hibernateUtil.FactoryProvider;

public class ForgetDao {

	
	public boolean checkLogin(String uname, String pass) {
		
		Session session= FactoryProvider.getFactory().openSession();
		Transaction tn= session.beginTransaction();
		Query query = session.createQuery(" update Users set pass=:pass where uname=:uname");

		query.setParameter("uname", uname);
		query.setParameter("pass", pass);

		int flag = query.executeUpdate();
		tn.commit();
		System.out.println("result of query:"+flag);

		if (flag == 1) {
			return true;
		}

		return false;
	}
}