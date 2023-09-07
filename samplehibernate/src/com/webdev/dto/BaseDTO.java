package com.webdev.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {
	
	private int id = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getListId(){
		return String.valueOf(id);
	}

	public String getListDescription(){
		return null;
	}
}
