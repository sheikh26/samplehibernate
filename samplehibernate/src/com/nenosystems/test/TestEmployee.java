package com.nenosystems.test;

import org.hibernate.*;

import com.nenosystems.dto.AddressDTO;
import com.nenosystems.dto.EmployeeDTO;
import com.nenosystems.utility.HibernateUtil;

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
		addr.setEmail("Galaxy@nenosystems.com");

		emp.setEmpAddr(addr);

		session.save(emp);
		System.out.println("Data is Saved");
		
		// session.delete(emp);

		transaction.commit();

		session.close();

	}
}
