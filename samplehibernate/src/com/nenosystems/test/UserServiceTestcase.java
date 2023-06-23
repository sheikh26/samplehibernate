package com.nenosystems.test;

import junit.fparamework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nenosystems.dto.UserDTO;
import com.nenosystems.exception.UserNotFoundException;
import com.nenosystems.services.UserService;
import com.nenosystems.services.UserServiceHibImpl;

public class UserServiceTestcase extends TestCase{

	UserService service = null;
	@Before
	public void setUp() throws Exception {
		service = new UserServiceHibImpl();
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void testAuthenticate() {

		UserDTO dto = new UserDTO();
		dto.setUserId("param");
		dto.setPassword("param");	

		try {
			dto = service.authenticate(dto);

			System.err.println("Last Name is " + dto.getLastName());

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

		dto = service.addUser(dto);

		assertTrue(dto.getId() > 0);
		
	/*	if( dto.getId() == 0){
			fail("User add fail);
		}*/

		System.out.println("***User Auto ID*****" + dto.getId());

	}

}
