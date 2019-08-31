package com.zzxx.crm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		Configuration config = new Configuration().configure();
		factory = config.buildSessionFactory();
	}
	
	public static Session openSession() {
		return factory.openSession();
	}
	
	public static Session getCurrentSession() {
		return factory.getCurrentSession();
	}

}
