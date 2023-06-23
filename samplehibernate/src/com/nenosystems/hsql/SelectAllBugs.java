package com.nenosystems.hsql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nenosystems.dto.BugDTO;
import com.nenosystems.utility.HibernateUtil;

public class SelectAllBugs {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT * FROM bugs
			
			String SQL_QUERY ="from BugDTO";
			
			Query query = session.createQuery(SQL_QUERY);
			
			List list = query.list();

			Iterator iter = list.iterator();

			BugDTO dto;

			System.out.println("ID\tSummary\t\tDescription\t\tStatus ID");
			while (iter.hasNext()) {
				dto =(BugDTO)iter.next();
				System.out.println(dto.getId() + "\t" + dto.getSummary()+ "\t\t" 
						+dto.getDescription()+ "\t\t" + dto.getStatusId());
			}

			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
