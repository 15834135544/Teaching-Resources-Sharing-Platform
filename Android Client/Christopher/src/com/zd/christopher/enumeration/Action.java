package com.zd.christopher.enumeration;

public class Action
{
	private final static String URL = "http://192.168.1.104:8181/Christopher/";
	
	public interface IActionEnum
	{
		public String getActionURL();
	}
	
	public enum EntityAction implements IActionEnum
	{
		COURSE_ACTION(URL + "courseAction"),
		FACULTY_ACTION(URL + "facultyAction"),
		STUDENT_ACTION(URL + "studentAction"),
		USER_ACTION(URL + "userAction"),
		DOCUMENT_ACTION(URL + "documentAction"),
		VIDEO_ACTION(URL + "videoAction"),
		ADMINISTRATOR_ACTION(URL + "administratorAction");
		
		private String actionURL;
			
		private EntityAction(String actionURL)
		{
			this.actionURL = actionURL;
		}
			
		public String getActionURL()
		{
			return actionURL;
		}
	}
}