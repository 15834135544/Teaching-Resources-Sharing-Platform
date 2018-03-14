package com.zd.christopher.controller;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

public class ActivityController implements IActivityController
{
	List<Activity> activityList = new LinkedList<Activity>();
	
	private ActivityController()
	{
		
	}
	
	private static class ActivityControllerFactory
	{
		private static ActivityController activityController = new ActivityController();
	}
	
	public static ActivityController getInstance()
	{
		return ActivityControllerFactory.activityController;
	}
	
	public boolean register(Activity activity)
	{
		if(activity == null)
			return false;
		activityList.add(activity);
		return true;
	}

	public boolean exitApp()
	{
        for (Activity activity : activityList)
            activity.finish();
        System.exit(0);
		return true;
	}

}
