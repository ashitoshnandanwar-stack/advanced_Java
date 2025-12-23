package com.cdac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO 
{
	private SessionFactory sessionFactory;

	public void saveProject(Project project)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(project);
		
		tx.commit();
		session.close();
		
		
	}

	public List<Project> viewAllProject() 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Project> list = session.createQuery("from Project", Project.class).list();
		session.close();
		return list;
	}
	
}
