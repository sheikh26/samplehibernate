package com.nenosystems.services;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nenosystems.dto.ApplicationDTO;
import com.nenosystems.utility.HibernateUtil;

public class ApplicationServiceHibImpl implements ApplicationService {

	public ApplicationDTO getApplication(int id) {
		Session session = HibernateUtil.currentSession();
		// Transaction tx = session.beginTransaction();

		Query q = session.createQuery(" from ApplicationDTO where id = ? ");

		q.setInteger(0, id);

		List list = q.list(); // new ArrayList<ApplicationDTO>();

		ApplicationDTO dto = null;

		Iterator it = list.iterator();

		if (it.hasNext()) {
			dto = (ApplicationDTO) it.next();
		}
		
		return dto;
	}

	public ApplicationDTO addApplication(ApplicationDTO dto) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();
		HibernateUtil.closeSession();
		
		System.out.println("***AddApplication Auto ID*****" + dto.getId());

		return dto;

	}


	public int deleteApplication(ApplicationDTO dto) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();
		HibernateUtil.closeSession();
		System.out.println("***User Auto ID*****" + dto.getId());
		// session.close();
		return 1;
	}

	public ApplicationDTO updateApplication(ApplicationDTO dto) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.update(dto);

		tx.commit();
		HibernateUtil.closeSession();
		System.out.println("***User Auto ID*****" + dto.getId());
		// session.close();
		// return 1;

		return dto;
	}

	public List<ApplicationDTO> getApplicationList() {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.currentSession();
		// Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from ApplicationDTO order by name");

		List<ApplicationDTO> list = q.list(); // new ArrayList<ApplicationDTO>();
	
		HibernateUtil.closeSession();

		return list;
	}

}
