package com.zd.christopher.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/*
 * 	Document - Course	* - 1
 * 	Document - User 	* - 1 
 * 	Document - User		* - *
 */
public class Document extends Entity
{
	private static final long serialVersionUID = 1L;
	private static final String DOCUMENT_ENTITY_PATH = ENTITY_PATH + "document/";
	
	private Integer id;			//PK
	private String documentName;
	private String url;
	private Date updatedTime;
	private String image;
	private String type;
	
	private Course course;
	private User author;
	private Set<User> favorUser = new HashSet<User>();
	
	public Document()
	{
		
	}
	
	public Document(Integer id)
	{
		this.id = id;
	}
	
	public Document(Integer id, String name, String url, Date updatedTime, Course course, User authorUser, Set<User> favorUser)
	{
		this.id = id;
		this.documentName = name;
		this.url = url;
		this.updatedTime = updatedTime;
		this.course = course;
		this.author = authorUser;
		this.favorUser = favorUser;
	}
	
	

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public Date getUpdatedTime()
	{
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime)
	{
		this.updatedTime = updatedTime;
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}
	

	public Set<User> getFavorUser()
	{
		return favorUser;
	}

	public void setFavorUser(Set<User> favorUser)
	{
		this.favorUser = favorUser;
	}

	public String getDocumentName() {
		return documentName;
	}

	public User getAuthor() {
		return author;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String findPath()
	{
		if(id == null)
			return null;
		return DOCUMENT_ENTITY_PATH + "document" + getDocumentName();
	}
	
	public static Document toJson(Document document)
	{
		Document tempDocument = null;
		try
		{
			tempDocument = (Document) document.clone();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Document jsonDocument = document;
		jsonDocument.course = new Course();
		jsonDocument.author = new User();
		if(tempDocument.getCourse() != null)
			jsonDocument.course.setId(tempDocument.getCourse().getId());
		if(tempDocument.getAuthor() != null)
		{
			jsonDocument.author.setId(tempDocument.getAuthor().getId());
			jsonDocument.author.setUserName(tempDocument.getAuthor().getUserName());
		}
		jsonDocument.favorUser = new HashSet<User>();
		for(User favorUser : tempDocument.getFavorUser())
		{
			User user = new User(favorUser.getId());
			jsonDocument.favorUser.add(user);
		}
		return jsonDocument;
	}
	
}
