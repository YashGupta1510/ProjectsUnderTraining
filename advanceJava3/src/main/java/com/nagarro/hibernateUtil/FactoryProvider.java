package com.nagarro.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.login.Users;

public class FactoryProvider {
public static SessionFactory factory;
public static SessionFactory getFactory() {
	try {
	if(factory==null) {
		factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
	}
	
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return factory;
}

public void closeFactory() {
	if(factory.isOpen()) {
		factory.close();
	}
}
}
