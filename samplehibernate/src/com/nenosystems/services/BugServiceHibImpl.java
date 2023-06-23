package com.nenosystems.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nenosystems.utility.HibernateUtil;


public class BugServiceHibImpl implements BugService {

	public List getBugsReport()
	{
			Session session = HibernateUtil.currentSession();

			Query q = session.createQuery("from BugDTO order by summary");
		
			List list = q.list();
			
			System.out.println(" Bugs List Size is  " + list.size());
			
			session.close();
			
			return list;
		}
	}
