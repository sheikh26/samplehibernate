package com.nenosystems.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nenosystems.dto.BugDTO;
import com.nenosystems.utility.HibernateUtil;

public class BugsSearch {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT * FROM bugs
			
			//String SQL_QUERY ="from BugDTO";
			
			//Query query = session.createQuery(SQL_QUERY);
			
			String searchSummary = null;
			String srearchDesc = "BUG%";
			int searchId =5 ;
						
			Criteria crit = session.createCriteria(BugDTO.class);
			
			if(searchId !=0){
				crit.add(Restrictions.eq("id", searchId));
			}
			if(srearchDesc != null){
				crit.add(Restrictions.like("description", srearchDesc));
			}
			if(searchSummary != null){
				crit.add(Restrictions.like("summary", srearchDesc));
			}
			
			List list = crit.list();

			Iterator<BugDTO> iter = list.iterator();

			BugDTO dto;

			System.out.println("ID\tSummary\t\tDescription\t\tStatus ID");
			System.out.println("--\t-------\t\t-----------\t\t------ ID");
			while (iter.hasNext()) {
				dto = iter.next();
				System.out.println(dto.getId() + "\t" + dto.getSummary()+ "\t\t" +dto.getDescription()+ "\t\t" + dto.getStatusId());
			}

			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
