package com.nagarro.advanceJava2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.nagarro.advanceJava2.model.Tshirt;

public class HibernateUtil {
	static Configuration cfg = new Configuration().configure().addAnnotatedClass(Tshirt.class);
	static StandardServiceRegistry reg = new StandardServiceRegistryBuilder().
			applySettings(cfg.getProperties()).build();
	public static SessionFactory sf = cfg.buildSessionFactory(reg);
	
	public static Session session = sf.openSession();

}
