package com.nagarro.springMVC1.util.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.springMVC1.model.Tshirt;
import com.nagarro.springMVC1.model.Users;


@Repository
public class HibernateUtil {
	
	private static SessionFactory sessionFactoryTshirt;
	private static SessionFactory sessionFactoryUser;

	public static SessionFactory getTshirtSessionFactory() {
		try {
			if (sessionFactoryTshirt == null) {
				sessionFactoryTshirt = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Tshirt.class)
						.buildSessionFactory();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sessionFactoryTshirt;
	}

	public static void closeFactoryTshirt() {
		if (sessionFactoryTshirt.isOpen()) {
			sessionFactoryTshirt.close();
		}
	}
	
	public static SessionFactory getUserSessionFactory() {
		try {
			if (sessionFactoryUser == null) {
				sessionFactoryUser = new Configuration().configure("hibernateValidation.cfg.xml")
						.addAnnotatedClass(Users.class)
						.buildSessionFactory();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sessionFactoryUser;
	}

	public void closeFactoryUsers() {
		if (sessionFactoryUser.isOpen()) {
			sessionFactoryUser.close();
		}
	}
	
	

}
