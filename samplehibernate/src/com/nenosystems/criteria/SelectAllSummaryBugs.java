package com.nenosystems.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.nenosystems.dto.BugDTO;
import com.nenosystems.utility.HibernateUtil;

public class SelectAllSummaryBugs {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT id, summary FROM bugs
			//String SQL_QUERY ="select b.id, b.summary from BugDTO b";
			//Query query = session.createQuery(SQL_QUERY);
			
			Criteria crit = session.createCriteria(BugDTO.class);
		
			crit.setProjection(Projections.property("summary"));

			List list = crit.list();
			
     		Iterator iter = list.iterator();

			Object row;

			System.out.println("Summary");
			System.out.println("-------");			
			while (iter.hasNext()) {
				
				row =iter.next();
				System.out.println(row);
			}

			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
