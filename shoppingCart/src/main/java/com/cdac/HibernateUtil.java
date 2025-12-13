package com.cdac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	private static SessionFactory factory;

    static {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
    }

    public static Session getSession() {
        return factory.openSession();
    }
}

// OR
//public class HibernateUtil {
//
//    public static Session getSession() {
//        return new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory()
//                .openSession();
//    }
//}
