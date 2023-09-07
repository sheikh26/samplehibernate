package com.webdev.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.webdev.dto.ApplicationDTO;
import com.webdev.dto.UserDTO;
import com.webdev.exception.UserNotFoundException;
import com.webdev.utility.HibernateUtil;

public class UserServiceHibImpl implements UserService {

	public UserDTO authenticate(UserDTO userDto) throws UserNotFoundException {

		Session session = HibernateUtil.currentSession();

		Query q = session
				.createQuery("from UserDTO where  userId = ? and password = ? ");

		q.setString(0, userDto.getUserId());
		q.setString(1, userDto.getPassword());

		List list = q.list();

		Iterator it = list.iterator();

		if (it.hasNext()) {
			userDto = (UserDTO) it.next();
		} else {
			throw new UserNotFoundException("login.invalid.user");

		}

		HibernateUtil.closeSession();

		return userDto;
	}

	public UserDTO addUser(UserDTO dto) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();
		HibernateUtil.closeSession();
		System.out.println("***User Auto ID*****" + dto.getId());

		return dto;

	}

	public UserDTO deleteUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO getUser(String loginId) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		UserDTO dto = null;

		dto = (UserDTO) session.get(UserDTO.class, loginId);

		tx.commit();
		HibernateUtil.closeSession();
		System.out.println("***User Auto ID*****" + dto.getId());

		return dto;

	}

	public UserDTO updateUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getUsers() {

		Session session = HibernateUtil.currentSession();
		// Transaction tx = session.beginTransaction();

		Query q = session
				.createQuery("from UserDTO order by lastName, firstName");

		List list = q.list(); // new ArrayList<ApplicationDTO>();

		HibernateUtil.closeSession();

		return list;
	}

	public static void main(String[] args) {

		UserDTO dto = new UserDTO();

		/*
		 * dto.setUserId("Arif"); dto.setPassword("Arif");
		 * 
		 * 
		 * UserService service = new UserServiceHibImpl();
		 * 
		 * dto = service.authenticate(dto);
		 * 
		 * System.out.println(dto.getAddress());
		 */

		dto.setUserId("tarun");
		dto.setPassword("tarun");
		dto.setLastName("Adiwal");
		dto.setAddress("parambag");

		UserService service = new UserServiceHibImpl();
		dto = service.addUser(dto);

		System.out.println(dto.getId());

	}

}
