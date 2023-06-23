package com.nenosystems.dto;

import java.sql.Timestamp ;

public class InsuranceDTO
{
	private int id			;
	private String name		;
	private double amount	;
	private Timestamp date	; 

	public void setId( int id )
	{
		this.id = id ; 
	}

	public int getId()
	{
		return id ;
	}

	public void setName( String name )
	{
		this.name = name ; 
	}

	public String getName()
	{
		return name ;
	} 

	public void setAmount( double amount )
	{
		this.amount = amount ; 
	}

	public double getAmount()
	{
		return amount ;
	} 

	public void setDate( Timestamp  date )
	{
		this.date = date ; 
	}

	public Timestamp getDate()
	{
		return date ;
	}

}