package com.webdev.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.webdev.dto.BugDTO;
import com.webdev.utility.HibernateUtil;

public class ListAllOpenBugs {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT b.id, b.summary, b.description, s.description  FROM bugs b,  status s where b.status_id = s.id and s.description = 'Open'
			
			String SQL_QUERY ="SELECT b.id, b.summary, b.description, s.description  FROM BugDTO b,  StatusDTO s " +
					"where b.statusId = s.id and s.description = 'Open' ";
			
			Query query = session.createQuery(SQL_QUERY);
			
			List list = query.list();

			Iterator iter = list.iterator();
			
			Object[] row;
			

			BugDTO dto;

			System.out.println("ID\tSummary\t\tDescription\t\tStatus");
			System.out.println("--\t-------\t\t-----------\t\t------");
			while (iter.hasNext()) {
				row = (Object[])iter.next();
				System.out.println(row[0] + "\t" + row[1]+ "\t\t" +row[2]+ "\t\t" + row[3]);
			}

			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
