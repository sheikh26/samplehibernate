package com.webdev.services;

import java.util.HashMap;
import java.util.ResourceBundle;

/*
 * ServiceLocator Follows following Design Patterns
 * 1. Singleton - Core Design Pattern
 * 2. Factory - Core Design Pattern
 * 3. ServoceLocator  - J2EE Design Pattern
 */

public class ServiceLocator {

	/**
	 * Static variable to hold single copy of ServiceLocator in an Application.
	 */
	private static ServiceLocator locator;

	/**
	 * Identify subsystem implementation.
	 */
	private final String DATABASE = ResourceBundle.getBundle(
			"com.webdev.resource.system").getString("dal");

	/*
	 * Service cache : Stores service instances for future use
	 */
	HashMap serviceCache = new HashMap();

	/*
	 * Default COnstuctor made private so that no one other class can create
	 * it's instance.
	 */
	private ServiceLocator() {
	}

	/*
	 * Return Service Locator Instance
	 */
	public static ServiceLocator getInstance() {

		if (locator == null) {
			locator = new ServiceLocator();
		}
		return locator;
	}

	public MarksheetService getMarksheetService() {

		System.out.println("Data Access Layer is " + DATABASE);

		MarksheetService service = (MarksheetService) serviceCache
				.get("msService");

		if (service == null) {
			if (DATABASE.equals("JDBC")) {
				service = new MarksheetServiceJdbcImpl();
			} else if (DATABASE.equals("Hibernate")) {
				service = new MarksheetServiceHibImpl();
			}

			serviceCache.put("msService", service);
		}

		return service;

	}

	public ContactService getContactService() {

		ContactService service = null;

		if (DATABASE == "Hibernate") {
			service = new ContactServiceHibImpl();

		} // else if (DATABASE == "manual"){
		// service = new UserServiceImpl();

		// }

		return service;

	}

	public UserService getUserService() {

		UserService service = (UserService) serviceCache.get("userService");
		
		System.out.println("DATABASE : " + DATABASE);

		if (service == null) {

			if (DATABASE.equals("Hibernate")) {
				service = new UserServiceHibImpl();
			} else if (DATABASE.equals("JDBC")) {
				service = new UserServiceJdbcImpl();
			}

			serviceCache.put("userService", service);

		}

		return service;

	}

	public BugService getBugService() {

		BugService service = (BugService) serviceCache.get("bugService");

		if (service == null) {

			if (DATABASE == "hibernate") {
				service = new BugServiceHibImpl();

			}

			serviceCache.put("bugService", service);

		}
		return service;

	}

	public ApplicationService getApplicationService() {

		ApplicationService service = null;

		if (DATABASE == "hibernate") {
			service = new ApplicationServiceHibImpl();

		} // else if (DATABASE == "manual"){
		// service = new ApplicationServiceImpl();

		// }

		return service;

	}
}
