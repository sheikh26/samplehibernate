package com.webdev.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.UserDTO;

public class TestNamedQuery {

	public static void main(String[] args) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.getNamedQuery("allUser");

		List l = q.list();
		Iterator it = l.iterator();

		UserDTO dto;
		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());

		}
		s.close();

	}

}
