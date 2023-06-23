package com.nenosystems.hsql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nenosystems.utility.HibernateUtil;

public class SelectAllIdSummaryBugs {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT id, summary FROM bugs
			
			String SQL_QUERY ="select b.id, b.summary from BugDTO b";
			
			Query query = session.createQuery(SQL_QUERY);
			
			List list = query.list();

     		Iterator iter = list.iterator();

			Object[] row;

			System.out.println("ID\tSummary");
			while (iter.hasNext()) {
				row = (Object[])iter.next();
				System.out.println(row[0] + "\t" + row[1]);
			}

			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
