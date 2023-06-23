package com.nenosystems.hsql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nenosystems.utility.HibernateUtil;

public class CountBugsGroupBy {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT count(*) FROM bugs : Aggregate funstion - sum, max, min
			
			String SQL_QUERY ="select b.statusId, count(*) from BugDTO  b group by b.statusId";
			
			Query query = session.createQuery(SQL_QUERY);
			
			List list = query.list();

     		Iterator iter = list.iterator();

			Object[] row;

			System.out.println("Staus ID\tCount");
			System.out.println("--------\t-----");
			while (iter.hasNext()) {
				row= (Object[])iter.next();
				System.out.println(row[0]+"\t"+row[1]);
			}

			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
