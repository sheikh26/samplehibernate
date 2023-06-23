package com.nenosystems.dto;

public class CustomDTO extends BaseDTO{
	
	private String feildName;
	private String feildType;
	private int feildSize;
	
	public String getFeildName() {
		return feildName;
	}
	public void setFeildName(String feildName) {
		this.feildName = feildName;
	}
	public int getFeildSize() {
		return feildSize;
	}
	public void setFeildSize(int feildSize) {
		this.feildSize = feildSize;
	}
	public String getFeildType() {
		return feildType;
	}
	public void setFeildType(String feildType) {
		this.feildType = feildType;
	}
	

}
