package com.nenosystems.test;

import java.util.Iterator;
import java.util.List;

import com.nenosystems.dto.MarksheetDTO;
import com.nenosystems.dto.UserDTO;
import com.nenosystems.services.MarksheetService;
import com.nenosystems.services.ServiceLocator;
import com.nenosystems.services.UserService;

public class TestServiceLocator {

	public static void main(String[] args) throws Exception {

		/**
		 * change com.nenosystems.resource.system.properties file to switch 
		 * between Hibernate and Jdbc
		 */

		System.out.println("############# Get Meritlist ############");
		testGetMeritList();

		System.out.println("############# Get List ############");
		testGetList();

		System.out.println("############# Authentocate User ############");
		authentocateUser();

	}

	public static void testGetMeritList() throws Exception {

		ServiceLocator locator = ServiceLocator.getInstance();
		MarksheetService service = locator.getMarksheetService();

		List list = service.getMeritList();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			MarksheetDTO dto = (MarksheetDTO) it.next();
			System.out.println("Role No" + dto.getRollNo());
			System.out.println("Name  " + dto.getName());
			System.out.println("Maths " + dto.getMaths());
			System.out.println("Physics " + dto.getPhysics());
			System.out.println("Chemistry " + dto.getChemistry());
			System.out.println("**");

		}

	}

	public static void authentocateUser() throws Exception {
		ServiceLocator locator = ServiceLocator.getInstance();
		UserService service = locator.getUserService();
		
		System.out.println("User Service " +  service);

		UserDTO userDTO = new UserDTO();
		userDTO.setUserId("param");
		userDTO.setPassword("param");

		userDTO = service.authenticate(userDTO);

		if (userDTO == null) {
			System.out.println("User Does Not Exist");
		} else {
			System.out.println("First Name : " + userDTO.getFirstName());
			System.out.println("Last Name : " + userDTO.getLastName());
			System.out.println("Address : " + userDTO.getAddress());
		}

	}

	public static void testGetList() throws Exception {

		ServiceLocator locator = ServiceLocator.getInstance();
		MarksheetService service = locator.getMarksheetService();

		List list = service.listMarksheet();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			MarksheetDTO dto = (MarksheetDTO) it.next();
			System.out.println("Role No" + dto.getRollNo());
			System.out.println("Name  " + dto.getName());
			System.out.println("Maths " + dto.getMaths());
			System.out.println("Physics " + dto.getPhysics());
			System.out.println("Chemistry " + dto.getChemistry());
			System.out.println("**");

		}

	}

}
