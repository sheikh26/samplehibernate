package com.nenosystems.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nenosystems.dto.UserDTO;
import com.nenosystems.exception.UserNotFoundException;
import com.nenosystems.services.UserService;
import com.nenosystems.services.UserServiceHibImpl;

public class AutoUserServiceTestcase {

	UserService service = null;

	@Before
	public void setUp() throws Exception {
		service = new UserServiceHibImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuthenticate() {

		UserDTO dto = new UserDTO();
		dto.setUserId("Galaxy");
		dto.setPassword("Galaxy");

		try {
			dto = service.authenticate(dto);
		} catch (UserNotFoundException e) {
		}

		System.err.println("Last Name is " + dto.getLastName());

		if ("Sahu".equals(dto.getLastName())) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");
		}

	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}


	public void testDeleteUser() {
		fail("Not yet implemented");
	}


	public void testGetUserInt() {
		fail("Not yet implemented");
	}


	public void testGetUserString() {
		fail("Not yet implemented");
	}


	public void testUpdateUser() {
		fail("Not yet implemented");
	}


	public void testGetUsers() {
		fail("Not yet implemented");
	}

}
