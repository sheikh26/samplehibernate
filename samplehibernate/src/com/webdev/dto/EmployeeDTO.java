package com.webdev.dto;

public class EmployeeDTO {
	
	private long id;

	private String firstName;

	private String lastName;

	private AddressDTO empAddr;
	

	public AddressDTO getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(AddressDTO empAddr) {
		this.empAddr = empAddr;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
