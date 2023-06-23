package com.nenosystems.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.nenosystems.dto.StatusDTO;
import com.nenosystems.utility.HibernateUtil;

public class SelectAllStatus {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.currentSession();

			//SELECT * FROM status
			
			String SQL_QUERY ="from StatusDTO";
			
			//Query query = session.createQuery(SQL_QUERY);
			
			Criteria crit = session.createCriteria(StatusDTO.class);
			
			List list = crit.list();


			Iterator<StatusDTO> iter = list.iterator();

			StatusDTO dto;

			System.out.println("ID\tDescription");
			System.out.println("--\t-----------");
			while (iter.hasNext()) {
				dto = iter.next();
				System.out.println(dto.getId() + "\t" + dto.getDescription());
			}

			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
