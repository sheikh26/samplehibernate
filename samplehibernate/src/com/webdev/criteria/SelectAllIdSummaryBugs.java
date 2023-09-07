package com.webdev.criteria;

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

public class SelectAllIdSummaryBugs {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT id, summary FROM bugs
			//String SQL_QUERY ="select b.id, b.summary from BugDTO b";
			//Query query = session.createQuery(SQL_QUERY);
			
			Criteria crit = session.createCriteria(BugDTO.class);
	
			
			ProjectionList p = Projections.projectionList();
			p.add(Projections.property("id"));
			p.add(Projections.property("summary"));
			
			crit.setProjection(p);

			List list = crit.list();
			
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
