package com.zd.christopher.enumeration;

import com.google.gson.Gson;

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
	
	public String toJsonString()
	{
		return new Gson().toJson(this);
	}
	
	public static Result createByJSON(String jsonStr)
	{
		if(jsonStr == null)
			return null;
		return new Gson().fromJson(jsonStr, Result.class);
	}
}
