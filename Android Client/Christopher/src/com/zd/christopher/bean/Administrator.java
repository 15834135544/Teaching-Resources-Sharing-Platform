package com.zd.christopher.bean;

import java.util.HashSet;
import java.util.Set;

/*
 * 	Administrator - User	1 - 1
 * 	Administrator - Course	* - *
 * 	
 */
public class Administrator extends Entity
{
	private static final long serialVersionUID = 1L;
	private static final String ADMINISTRATOR_ENTITY_PATH = ENTITY_PATH + "administrator";
	
	private Integer id;
	
	private User user;
	private Set<Course> course = new HashSet<Course>();
	
	public Administrator()
	{
		
	}
	
	public Administrator(Integer id)
	{
		this.id = id;
	}
	
	public Administrator(Integer id, User user, Set<Course> course)
	{
		this.id = id;
		this.user = user;
		this.course = course;
	}
	

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public Set<Course> getCourse()
	{
		return course;
	}
	public void setCourse(Set<Course> course)
	{
		this.course = course;
	}

	public String findPath()
	{
		if(id == null || user == null)
			return null;
		return ADMINISTRATOR_ENTITY_PATH + "administrator" + getId();
	}
	
	public Administrator toJson(Administrator administrator)
	{
		Administrator tempAdministrator = null;
		try
		{
			tempAdministrator = (Administrator) administrator.clone();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Administrator jsonAdministrator = administrator;
		jsonAdministrator.user = new User();
		jsonAdministrator.course = new HashSet<Course>();
		if(administrator.getUser() != null)
			jsonAdministrator.user.setId(administrator.getUser().getId());
		for(Course chargedCourse : tempAdministrator.getCourse())
		{
			Course course = new Course(chargedCourse.getId());
			jsonAdministrator.course.add(course);
		}
		return jsonAdministrator;
	}
}
