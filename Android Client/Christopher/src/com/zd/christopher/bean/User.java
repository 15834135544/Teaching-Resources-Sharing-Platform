package com.zd.christopher.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.zd.christopher.cipher.MD5CipherMaker;

public class User extends Entity
{
	private static final long serialVersionUID = 1L;
	private static final String USER_ENTITY_PATH = ENTITY_PATH + "/user";
	
	private Integer id;
	private String userId;
	private transient String pwd;
	private String userName;
	private String encryptedPwd;
	private String avatar;
	private Date birthday;
	private String gender;
	private String email;
	private String phone;
	private String fax;
	private String address;
	private String zipCode;
	private String country;
	private String nationality;
	private String idCard;
	
	private Set<Course> favorCourse = new HashSet<Course>();
	private Administrator administrator;
	private Set<Document> favorDocument = new HashSet<Document>();
	private Set<Document> authorDocument = new HashSet<Document>();
	private Set<Video> favorVideo = new HashSet<Video>();
	private Set<Video> authorVideo = new HashSet<Video>();
	private Faculty faculty;
	private Student student;
	
	public User()
	{
		
	}

	public User(Integer id)
	{
		this.id = id;
	}
	
	public User(String userId)
	{
		this.userId = userId;
	}
	
	public User(String userId, String pwd)
	{
		this.userId = userId;
		this.pwd = pwd;
		setDefaultUserName();
		setDefaultEmail();
		calculateEncryptedPwd();
	}
	
	public User(String userId, String pwd, String avatar,
			Date birthday, String gender, String email, String phone,
			String fax, String address, String zipCode, String country,
			String nationality, String idCard)
	{
		this.userId = userId;
		this.pwd = pwd;
		this.avatar = avatar;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.fax = fax;
		this.address = address;
		this.zipCode = zipCode;
		this.country = country;
		this.nationality = nationality;
		this.idCard = idCard;
		setDefaultUserName();
		setDefaultEmail();
		calculateEncryptedPwd();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getAvatar()
	{
		return avatar;
	}
	
	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}
	
	public Faculty getFaculty() 
	{
		return faculty;
	}

	public void setFaculty(Faculty faculty) 
	{
		this.faculty = faculty;
	}
	
	public Student getStudent() 
	{
		return student;
	}

	public void setStudent(Student student) 
	{
		this.student = student;
	}

	public String getPwd() 
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
		calculateEncryptedPwd();
	}

	public String getEncryptedPwd() 
	{
		return encryptedPwd;
	}
	
	public void setEncryptedPwd(String encryptedPwd)
	{
		this.encryptedPwd = encryptedPwd;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public String getGender()
	{
		return gender;
	}

	public String getEmail()
	{
		return email;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getFax()
	{
		return fax;
	}

	public String getAddress()
	{
		return address;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public String getCountry()
	{
		return country;
	}

	public String getNationality()
	{
		return nationality;
	}

	public String getIdCard()
	{
		return idCard;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}

	public void setIdCard(String idCard)
	{
		this.idCard = idCard;
	}

	public Set<Course> getFavorCourse()
	{
		return favorCourse;
	}
	
	public void setFavorCourse(Set<Course> favorCourse) 
	{
		this.favorCourse = favorCourse;
	}

	public Set<Video> getFavorVideo() 
	{
		return favorVideo;
	}
	
	public void setFavorVideo(Set<Video> favorVideo)
	{
		this.favorVideo = favorVideo;
	}
	
	public Set<Video> getAuthorVideo() 
	{
		return authorVideo;
	}

	public void setAuthorVideo(Set<Video> authorVideo) 
	{
		this.authorVideo = authorVideo;
	}

	public Administrator getAdministrator()
	{
		return administrator;
	}

	public void setAdministrator(Administrator administrator)
	{
		this.administrator = administrator;
	}

	public Set<Document> getFavorDocument()
	{
		return favorDocument;
	}

	public void setFavorDocument(Set<Document> favorDocument)
	{
		this.favorDocument = favorDocument;
	}

	public Set<Document> getAuthorDocument()
	{
		return authorDocument;
	}

	public void setAuthorDocument(Set<Document> authorDocument)
	{
		this.authorDocument = authorDocument;
	}

	private boolean calculateEncryptedPwd()
	{
		if(pwd == null)
			return false;
		this.encryptedPwd = MD5CipherMaker.cipher(pwd);
		return true;
	}
	
	private boolean setDefaultUserName()
	{
		if(userId == null)
			return false;
		userName = userId;
		return true;
	}
	
	private boolean setDefaultEmail()
	{
		if(userId == null)
			return false;
		email = userId;
		return true;
	}
	
	public String findPath()
	{
		if(id == null)
			return null;
		return USER_ENTITY_PATH + "user" + getUserId();
	}
	
	public static User toJson(User user)
	{
		User tempUser = null;
		try
		{
			tempUser = (User) user.clone();
		} 
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		User jsonUser = user;
		jsonUser.faculty = new Faculty();
		jsonUser.student = new Student();
		jsonUser.administrator = new Administrator();
		jsonUser.favorCourse = new HashSet<Course>();
		jsonUser.favorDocument = new HashSet<Document>();
		jsonUser.favorVideo = new HashSet<Video>();
		jsonUser.authorDocument = new HashSet<Document>();
		jsonUser.authorVideo = new HashSet<Video>();
		if(tempUser.getFaculty() != null)
			jsonUser.faculty.setId(tempUser.getFaculty().getId());
		if(tempUser.getStudent() != null)
			jsonUser.student.setId(tempUser.getStudent().getId());
		if(tempUser.getAdministrator() != null)
			jsonUser.administrator.setId(tempUser.getAdministrator().getId());
		for(Course favorCourse : tempUser.getFavorCourse())
		{
			Course course = new Course(favorCourse.getId());
			jsonUser.favorCourse.add(course);
		}
		for(Document favorDocument : tempUser.getFavorDocument())
		{
			Document document = new Document(favorDocument.getId());
			jsonUser.favorDocument.add(document);
		}
		for(Video favorVideo : tempUser.getFavorVideo())
		{
			Video video = new Video(favorVideo.getId());
			jsonUser.favorVideo.add(video);
		}
		for(Document authorDocument : tempUser.getAuthorDocument())
		{
			Document document = new Document(authorDocument.getId());
			jsonUser.authorDocument.add(document);
		}
		for(Video authorVideo : tempUser.getAuthorVideo())
		{
			Video video = new Video(authorVideo.getId());
			jsonUser.authorVideo.add(video);
		}
		return jsonUser;
	}
	
}
