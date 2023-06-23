package com.nenosystems.dto;

import java.util.Date;

public class ApplicationDTO extends BaseDTO {

	private String name = null;

	private String description = null;

	private Date startDate = null;

	private Date completeDate = null;

	/**
	 * @return the completeDate
	 */
	public Date getCompleteDate() {
		return completeDate;
	}

	/**
	 * @paparam completeDate
	 *            the completeDate to set
	 */
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @paparam description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @paparam name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @paparam startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
