package com.nenosystems.dto;

public class StatusDTO extends BaseDTO {
	
	private int id;
	private String description;
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @paparam description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @paparam id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
