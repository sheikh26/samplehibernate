package com.webdev.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.webdev.dto.UserDTO;
import com.webdev.exception.UserNotFoundException;
import com.webdev.services.UserService;
import com.webdev.services.UserServiceHibImpl;

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

		if ("Sheikh".equals(dto.getLastName())) {
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
