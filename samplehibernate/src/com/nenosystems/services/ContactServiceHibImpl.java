package com.nenosystems.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nenosystems.dto.ContactDTO;
import com.nenosystems.utility.HibernateUtil;

public class ContactServiceHibImpl implements ContactService {
	
	public ContactDTO addContact(ContactDTO contactDTO)
	{
		Session session=HibernateUtil.currentSession();
		
		Transaction tx = session.beginTransaction();

		session.save(contactDTO);

		tx.commit();
		
		HibernateUtil.closeSession();
		
		System.out.println("***Contact Auto ID*****" + contactDTO.getId());
		
		
		
		return contactDTO;
		
	}
	

}
