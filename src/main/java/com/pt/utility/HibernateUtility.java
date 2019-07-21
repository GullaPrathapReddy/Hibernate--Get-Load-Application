package com.pt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private static Session ses;
	private static SessionFactory factory;
	private static Configuration cfg;
	static {
		cfg = new Configuration();
		cfg.configure("com/pt/cfgs/hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}

	public static Session getInstance() {
		ses = factory.openSession();
		return ses;
	}

	public static void closeSession(Session ses) {
		if (ses != null) {
			ses.close();
		}
	}

	public static void CloseFactory() {
		if (factory != null) {
			factory.close();
		}
	}
}
