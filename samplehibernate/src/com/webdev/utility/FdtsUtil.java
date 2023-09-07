package com.webdev.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FdtsUtil {
	
	public static Date getDate(String dStr){
		
		Date date = null;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			date = dateFormat.parse(dStr);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return date; 
		
	}
	
	public static String getString(Date date){
				
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			return null;
		}		
	
	}
	
	public static void main(String[] args){
		Date d = getDate("16/11/2006");
		System.out.println(d);
		System.out.println("Formatted date" + getString(d));
		
	}
	
	
	
	
	

}
