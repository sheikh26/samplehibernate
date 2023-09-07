package com.webdev.hsql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.webdev.dto.BugDTO;
import com.webdev.utility.HibernateUtil;

public class SelectAllSummaryBugs {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT id, summary FROM bugs
			String SQL_QUERY ="select b.summary from BugDTO b";
			Query query = session.createQuery(SQL_QUERY);
			
			List list = query.list();
			
     		Iterator iter = list.iterator();

			Object o;

			System.out.println("Summary");
			System.out.println("-------");			
			while (iter.hasNext()) {
				o = iter.next();
				System.out.println(o);
			}

			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
