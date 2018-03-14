package com.zd.christopher.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/*
 * 	Video - Course	* - 1
 * 	Video - User 	* - 1 
 * 	Video - User	* - * 
 */
public class Video extends Entity
{
	private static final long serialVersionUID = 1L;
	private static final String VIDEO_ENTITY_PATH = ENTITY_PATH + "video/";
	
	private Integer id;			//PK
	private String videoName;
	private String url;
	private Date updateTime;
	private String image;
	private String type;
	
	private Course course;
	private User author;
	private Set<User> favorUser = new HashSet<User>();
	
	public Video()
	{
		
	}
	
	public Video(Integer id)
	{
		this.id = id;
	}
	

	public Video(Integer id, String name, String url, Date updateTime, Course course, User authorUser, Set<User> favorUser)
	{
		this.id = id;
		this.videoName = name;
		this.url = url;
		this.updateTime = updateTime;
		this.course = course;
		this.author = authorUser;
		this.favorUser = favorUser;
	}

	

	public String getImage()
	{
		return image;
	}

	public String getType()
	{
		return type;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getVideoName() {
		return videoName;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public User getAuthor() {
		return author;
	}


	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public void setAuthor(User author) {
		this.author = author;
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
	public Date getUpdatedTime()
	{
		return updateTime;
	}
	public void setUpdatedTime(Date updatedTime)
	{
		this.updateTime = updatedTime;
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public User getAuthorUser()
	{
		return author;
	}

	public void setAuthorUser(User authorUser)
	{
		this.author = authorUser;
	}

	public Set<User> getFavorUser()
	{
		return favorUser;
	}

	public void setFavorUser(Set<User> favorUser)
	{
		this.favorUser = favorUser;
	}

	public String findPath()
	{
		if(id == null)
			return null;
		return VIDEO_ENTITY_PATH + "video" + getVideoName();
	}
	
	public static Video toJson(Video video)
	{
		Video tempVideo = null;
		try
		{
			tempVideo = (Video) video.clone();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Video jsonVideo = video;
		jsonVideo.course = new Course();
		jsonVideo.author = new User();
		if(tempVideo.getCourse() != null)
			jsonVideo.course.setId(tempVideo.getCourse().getId());
		if(tempVideo.getAuthor() != null)
			jsonVideo.author.setId(tempVideo.getAuthor().getId());
		jsonVideo.favorUser = new HashSet<User>();
		for(User favorUser : tempVideo.getFavorUser())
		{
			User user = new User(favorUser.getId());
			jsonVideo.favorUser.add(user);
		}
		return jsonVideo;
	}
	
}	
