package com.webdev.test;

import org.hibernate.*;

import com.webdev.dto.AddressDTO;
import com.webdev.dto.EmployeeDTO;
import com.webdev.utility.HibernateUtil;

public class TestEmployee {
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();

		EmployeeDTO emp = new EmployeeDTO();
		emp.setId(1);
		emp.setFirstName("Galaxy");
		emp.setLastName("technologies");

		AddressDTO addr = new AddressDTO();
		addr.setId(emp.getId());
		addr.setStreet("Trade House");
		addr.setCity("Indore");
		addr.setState("M.P.");
		addr.setZip("452001");
		addr.setEmail("Galaxy@webdev.com");

		emp.setEmpAddr(addr);

		session.save(emp);
		System.out.println("Data is Saved");
		
		// session.delete(emp);

		transaction.commit();

		session.close();

	}
}
