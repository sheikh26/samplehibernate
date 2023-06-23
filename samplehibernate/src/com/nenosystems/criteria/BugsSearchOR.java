package com.nenosystems.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.nenosystems.dto.BugDTO;
import com.nenosystems.utility.HibernateUtil;

public class BugsSearchOR {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT * FROM bugs
			
			//String SQL_QUERY ="from BugDTO";
			
			//Query query = session.createQuery(SQL_QUERY);
			
			String searchSummary = "BUG%";
			String srearchDesc = "BUG%";
			int searchId =0 ;
						
			Criteria crit = session.createCriteria(BugDTO.class);
			SimpleExpression exId=null,exDec=null,exSum=null;
			
			if(searchId !=0){
				exId = Restrictions.eq("id", searchId);
			}
			if(srearchDesc != null){
				exDec = Restrictions.like("description", srearchDesc);
			}
			if(searchSummary != null){
				exSum = Restrictions.like("summary", srearchDesc);
			}
			if(exId != null){
				crit.add( Restrictions.or(exId,Restrictions.and(exDec,exSum)));
			}else {
				crit.add( exDec);
				crit.add( exSum);
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
