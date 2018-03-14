package com.zd.christopher.enumeration;

import com.zd.christopher.activity.BaseActivity;
import com.zd.christopher.activity.MainActivity;
import com.zd.christopher.activity.StartActivity;

public enum Activity
{
	START_ACTIVITY("StartActivity", StartActivity.class),
	BASE_ACTIVITY("BaseActivity", BaseActivity.class),
	MAIN_ACTIVITY("MainActivity", MainActivity.class),
	;
	
	private String name;
	private Class<?> activityClass;
	
	private Activity(String name, Class<?> activityClass)
	{
		this.name = name;
		this.activityClass = activityClass;
	}
		
	public String getActivityName()
	{
		return name;
	}
	
	public Class<?> getActivity()
	{
		return activityClass;
	}
}
