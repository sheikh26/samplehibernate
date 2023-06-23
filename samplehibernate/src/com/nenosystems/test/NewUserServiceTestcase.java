package com.nenosystems.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nenosystems.dto.UserDTO;
import com.nenosystems.exception.UserNotFoundException;
import com.nenosystems.services.ServiceLocator;
import com.nenosystems.services.UserService;

public class NewUserServiceTestcase {

	// @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	// @AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testAuthenticate() {

		UserDTO dto = new UserDTO();
		dto.setUserId("param");
		dto.setPassword("param");

		UserService service = ServiceLocator.getInstance().getUserService();

		try {
			dto = service.authenticate(dto);

			System.out.println("Last Name is " + dto.getLastName());

			assertEquals("Nigam", dto.getLastName());

		} catch (UserNotFoundException e) {
			fail(dto.getUserId() + "User IS Not found");
		}

	}

	@Test
	public void testAddUser() {
		UserDTO dto = new UserDTO();

		dto.setUserId("rupesh");
		dto.setPassword("rupesh");
		dto.setFirstName("Rupesh");
		dto.setLastName("S");
		dto.setAddress("Palasia");

		UserService service = ServiceLocator.getInstance().getUserService();

		dto = service.addUser(dto);

		assertTrue("User is not Inserted", dto.getId() > 0);

		System.out.println("***User Auto ID*****" + dto.getId());
	}

	//@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	//@Test
	public void testGetUserInt() {
		fail("Not yet implemented");
	}

	//@Test
	public void testGetUserString() {
		fail("Not yet implemented");
	}

	//@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	//@Test
	public void testGetUsers() {
		fail("Not yet implemented");
	}

	// @Test
	public void testMain() {
		System.out.println("testMain");
		fail("Not yet implemented");
	}

}
