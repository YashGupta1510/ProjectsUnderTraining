package com.nagarro.login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LoginDao {

	public boolean checkLogin(String uname, String pass) {

		SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session = factory.openSession();// gives hibernate session
		session.beginTransaction();
		Query query = session.createQuery("from Users where uname=:uname AND  pass=:pass");

		query.setParameter("uname", uname);
		query.setParameter("pass", pass);
		try {
			Users user = (Users) query.getSingleResult();

			System.out.println("User found  =>> " + user.toString());

			session.getTransaction().commit();
			if (user != null) {
				return true;
			}
		} catch (Exception e) {
		}

		return false;

	}
}