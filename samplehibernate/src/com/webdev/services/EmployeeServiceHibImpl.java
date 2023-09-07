package com.webdev.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.webdev.dto.EmployeeDTO;
import com.webdev.utility.HibernateUtil;

public class EmployeeServiceHibImpl {
	public EmployeeDTO addEmployee(EmployeeDTO dto) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();
		HibernateUtil.closeSession();

		return dto;
	}

	public void deleteEmployee(EmployeeDTO dto) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();
		HibernateUtil.closeSession();
	}

	public EmployeeDTO updateEmployee(EmployeeDTO dto) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();
		HibernateUtil.closeSession();

		return dto;
	}

	public EmployeeDTO getEmployee(long id) {
		EmployeeDTO dto =null;
		
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		dto = (EmployeeDTO) session.load(EmployeeDTO.class, new Long(id));

		tx.commit();
		HibernateUtil.closeSession();
		return dto;
	}

	public List getEmployeeList() {
		return null;
	}

}
