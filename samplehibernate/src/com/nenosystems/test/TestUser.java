package com.nenosystems.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.nenosystems.dto.UserDTO;
import com.nenosystems.exception.LoginException;

/**
 * Example for CRUD operation, HQL, and Named Query
 * 
 * @author param Sheikh
 *
 */


public class TestUser {

	// authenticate user using with HQL query
	public static void authonticateUserWithHQL() throws Exception {

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		// Enter User ID & Password from Keyboard eg param/param
		String usr = null, pass = null;

		System.out.println("Enter User Id = ");
		usr = bf.readLine();
		System.out.println("Enter Password = ");
		pass = bf.readLine();

		Query q = s.createQuery("from UserDTO where userId=? and password=?");
		q.setString(0, usr);
		q.setString(1, pass);

		List l = q.list();
		Iterator it = l.iterator();

		UserDTO userDTO = null;

		if (it.hasNext()) {

			userDTO = (UserDTO) it.next();
			System.out.println("First Name : " + userDTO.getFirstName());
			System.out.println("Last Name : " + userDTO.getLastName());
			System.out.println("Address : " + userDTO.getAddress());
		} else {
			System.out.println("User does not exists");
		}
		s.close();

	}// authonticateUserWithoutHSQL()

	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		//testDelete();
		//testList();
		//testGet();
		//testLoad();
		//authonticateUserWithHQL();
		//testNamedQuery();
		//testSelectedColumnList();
		testDirtyCheck();

	}

	public static void testAdd() throws Exception {

		UserDTO dto = new UserDTO();
		dto.setFirstName("Anup");
		dto.setLastName("Nigam");
		dto.setAddress("Sahlimar Corporate");
		dto.setUserId("dheeray");
		dto.setPassword("pwd123");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(dto);

		tx.commit();
		s.close();

	}

	public static void testUpdate() throws Exception {

		UserDTO dto = new UserDTO();
		dto.setId(5);
		dto.setFirstName("Anup");
		dto.setLastName("Nigam");
		dto.setAddress("South Tukoganj");
		dto.setUserId("anup");
		dto.setPassword("pwd123");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.update(dto);

		tx.commit();
		s.close();

	}


	public static void testDirtyCheck() throws Exception {


		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		UserDTO dto = (UserDTO)s.get(UserDTO.class, 5);
		dto.setFirstName("Vijay");

		tx.commit();
		s.close();

	}
	
	
	public static void testGet() throws Exception {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();

		UserDTO dto = (UserDTO) s.get(UserDTO.class, 5);

		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());

		s.close();

	}

	public static void testLoad() throws Exception {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		UserDTO dto = (UserDTO) s.get(UserDTO.class, 4);

		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());

		dto.setLastName(dto.getLastName() + "New");
		tx.commit();
		s.close();

	}

	public static void testDelete() throws Exception {

		UserDTO dto = new UserDTO();
		dto.setId(4);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.delete(dto);

		tx.commit();
		s.close();

	}

	public static void testList() throws Exception {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.createQuery("from UserDTO");

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

	

	public static void testSelectedColumnList() throws Exception {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.createQuery("select u.id, u.firstName, u.lastName from UserDTO u");

		List l = q.list();
		Iterator it = l.iterator();
		
		Object[] rows =null;

		UserDTO dto;
		while (it.hasNext()) {
			rows = (Object[]) it.next();
			Integer id = (Integer)rows[0];
			String fn = (String)rows[1];
			String ln = (String)rows[2];
			System.out.println( id +  "\t" + fn + "\t" + ln);

		}
		s.close();
	}
	
	
	public static void testNamedQuery() throws Exception {

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

	public static UserDTO authenticate(UserDTO userDto) throws Exception {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory(); // Load Factory
		Session s = sessionFactory.openSession(); // Create Session

		Query q = s
				.createQuery("from UserDTO where  userId = ? and password = ? ");
		q.setString(0, userDto.getUserId());
		q.setString(1, userDto.getPassword());

		List list = q.list();

		Iterator it = list.iterator();
		if (it.hasNext()) {
			userDto = (UserDTO) it.next();
		} else {
			throw new LoginException("login.invalid.user");
		}
		s.close();
		return userDto;
	}
}
