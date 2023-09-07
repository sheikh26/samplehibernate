package com.webdev.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.webdev.dto.BugDTO;
import com.webdev.utility.HibernateUtil;

public class CountBugs {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT count(*) FROM bugs : Aggregate funstion - sum, max, min
			
			//String SQL_QUERY ="select count(*) from BugDTO";
			
			//Query query = session.createQuery(SQL_QUERY);
			
			Criteria crit = session.createCriteria(BugDTO.class);
			
	        crit.setProjection(Projections.count("id"));
			
			List list = crit.list();

     		Iterator iter = list.iterator();

			System.out.println("Count");
			System.out.println("-----");
			while (iter.hasNext()) {
				Integer o = (Integer)iter.next();
				System.out.println(o);
			}

			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
