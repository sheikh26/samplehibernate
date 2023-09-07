package com.webdev.dto;

public class MarksheetDTO {

	private String rollNo;
	
	private String name;

	private int physics;

	private int chemistry;

	private int maths;

	/**
	 * @return the chemistry
	 */
	public int getChemistry() {
		return chemistry;
	}

	/**
	 * @paparam chemistry the chemistry to set
	 */
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	/**
	 * @return the maths
	 */
	public int getMaths() {
		return maths;
	}

	/**
	 * @paparam maths the maths to set
	 */
	public void setMaths(int maths) {
		this.maths = maths;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @paparam name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the physics
	 */
	public int getPhysics() {
		return physics;
	}

	/**
	 * @paparam physics the physics to set
	 */
	public void setPhysics(int physics) {
		this.physics = physics;
	}

	/**
	 * @return the rollNo
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * @paparam rollNo the rollNo to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}




}
