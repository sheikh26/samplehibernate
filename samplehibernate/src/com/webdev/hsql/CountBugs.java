package com.webdev.hsql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.webdev.utility.HibernateUtil;

public class CountBugs {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT count(*) FROM bugs : Aggregate funstion - sum, max, min
			
			String SQL_QUERY ="select count(*) from BugDTO";
			
			Query query = session.createQuery(SQL_QUERY);
			
			List list = query.list();

     		Iterator iter = list.iterator();

			Object[] row;

			System.out.println("Count");
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
