package com.nenosystems.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import junit.fparamework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nenosystems.dto.ApplicationDTO;
import com.nenosystems.services.ApplicationService;
import com.nenosystems.services.ApplicationServiceHibImpl;

public class ApplicationServiceTestcase extends TestCase {

	ApplicationService service = null;

	@Before
	public void setUp() throws Exception {
		service = new ApplicationServiceHibImpl();
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void testGetApplication() {
		
		ApplicationDTO applicationDTO = new ApplicationDTO();
		applicationDTO.setName("Test Module 1");
		applicationDTO
				.setDescription("This is a test module from JUnit tesecase"
						+ new Date());
		// applicationDTO.setStartDate("11/11/2006");
		// applicationDTO.setCompleteDate("11/11/2006");

		applicationDTO = service.addApplication(applicationDTO);

		System.err.println("App Name is " + applicationDTO.getName());

		applicationDTO = service.getApplication(applicationDTO.getId());

		assertEquals("Test Module 1", applicationDTO.getName());
	}

	@Test
	public void testAddApplication() {

		ApplicationDTO applicationDTO = new ApplicationDTO();
		applicationDTO.setName("Test Module 1");
		applicationDTO
				.setDescription("This is a test module from JUnit tesecase"
						+ new Date());
		// applicationDTO.setStartDate("11/11/2006");
		// applicationDTO.setCompleteDate("11/11/2006");

		applicationDTO = service.addApplication(applicationDTO);

		System.err.println("App Name is " + applicationDTO.getName());

		applicationDTO = service.getApplication(applicationDTO.getId());

		assertEquals("Test Module 1", applicationDTO.getName());

	}

	@Test
	public void testDeleteApplication() {

		ApplicationDTO applicationDTO = new ApplicationDTO();
		applicationDTO.setName("Test Module 1");
		applicationDTO
				.setDescription("This is a test module from JUnit tesecase");
		// applicationDTO.setStartDate("11/11/2006");
		// applicationDTO.setCompleteDate("11/11/2006");

		applicationDTO = service.addApplication(applicationDTO);

		int appId = applicationDTO.getId();

		applicationDTO = service.getApplication(appId);

		assertEquals("Test Module 1", applicationDTO.getName());

		service.deleteApplication(applicationDTO);

		applicationDTO = service.getApplication(appId);

		assertNull(applicationDTO);
	}

	@Test
	public void testUpdateApplication() {

		ApplicationDTO applicationDTO = service.getApplication(1);

		String str = "This is a test module update from JUnit tesecase"
				+ new Date();

		applicationDTO.setDescription(str);

		applicationDTO = service.updateApplication(applicationDTO);

		applicationDTO = service.getApplication(1);

		assertEquals(str, applicationDTO.getDescription());
	}

	@Test
	public void testGetApplicationList() {
		List list = service.getApplicationList();
		assertTrue(list.size() > 0);
	}

}
