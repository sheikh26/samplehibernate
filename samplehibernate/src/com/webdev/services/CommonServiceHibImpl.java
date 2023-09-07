package com.webdev.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.webdev.dto.ModuleDTO;
import com.webdev.dto.UserDTO;
import com.webdev.utility.HibernateUtil;

public class CommonServiceHibImpl implements CommonService {

	public ModuleDTO[] getModuleList() {

		Session session = HibernateUtil.currentSession();
		// Transaction tx = session.beginTransaction();

		Query q = session
				.createQuery("id,lastName, firstName from UserDTO order by lastName, firstName");

		List list = q.list();

		HibernateUtil.closeSession();

		ModuleDTO[] array = null;

		return array;

	}

	public UserDTO[] getUserList() {

		Session session = HibernateUtil.currentSession();
		// Transaction tx = session.beginTransaction();

		Query q = session
				.createQuery("id,lastName, firstName from UserDTO order by lastName, firstName");

		List list = q.list();

		HibernateUtil.closeSession();

		UserDTO[] array = null;

		return array;
	}

}
