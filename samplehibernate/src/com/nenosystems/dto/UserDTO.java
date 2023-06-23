package com.nenosystems.dto;

public class UserDTO extends BaseDTO {

	private String lastName = null;

	private String firstName = null;

	private String address = null;

	private String userId = null;

	private String password = null;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer("User Information \n");
		sb.append("User ID : " + userId + "\n");
		sb.append("Password : " + password + "\n");
		sb.append("First Name : " + firstName + "\n");
		sb.append("Last Name : " + lastName + "\n");

		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nenosystems.dto.BaseDTO#getListDescription()
	 */

	public String getListDescription() {
		
		return lastName + "," + firstName;
	}

}
