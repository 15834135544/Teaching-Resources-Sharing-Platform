package com.zd.christopher.enumeration;

public class Action
{
	private final static String URL = "http://localhost:8888/christopher/";
	
	public interface IActionEnum
	{
		public String getActionURL();
	}
	
	public enum DAOAction implements IActionEnum
	{
		ENTITY_DAO_ACTION(URL + "dao/entityDAOAction"),
		COURSE_DAO_ACTION(URL + "dao/courseDAOAction"),
		COURSE_RESOURCE_DAO_ACTION(URL + "dao/courseResourceDAO"),
		FACULTY_DAO_ACTION(URL + "dao/facultyDAO"),
		STUDENT_DAO_ACTION(URL + "dao/tudentDAO"),
		USER_DAO_ACTION(URL + "dao/userDAO");
		
		private String actionURL;
			
		private DAOAction(String actionURL)
		{
			this.actionURL = actionURL;
		}
			
		public String getActionURL()
		{
			return actionURL;
		}
	}
}