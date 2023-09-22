package com.nagarro.springMVC1.util.login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.springMVC1.model.Users;
import com.nagarro.springMVC1.util.hibernate.HibernateUtil;


@Repository
public class LoginServices {

	@Autowired
	HibernateUtil hibernateUtil;
	
	public boolean verfiyUser(String username, String password) {

		SessionFactory sf = hibernateUtil.getUserSessionFactory();
		Users user = null;
		try {
			System.out.println("----------[LoginServices]---------");
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Users where username =:_username and password =:_password");
			query.setParameter("_username", username);
			query.setParameter("_password", password);
			user = (Users) query.getSingleResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (user != null) {
			return true;
		}
		return false;

	}

}
