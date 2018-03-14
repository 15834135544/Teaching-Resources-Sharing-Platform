package com.zd.christopher.enumeration;


public enum Result
{
	SUCCESS("SUCCESS"),
	FAILURE("FAILURE");
	
	private String result;
	
	Result(String result)
	{
		this.result = result;
	}
	
	public String getString()
	{
		return result;
	}
	

}
