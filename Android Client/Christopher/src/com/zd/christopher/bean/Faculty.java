package com.zd.christopher.bean;



import java.util.HashSet;
import java.util.Set;
/*
 * 	Faculty - Course	1 - *
 * 	Faculty - User		1 - 1
 */
public class Faculty extends Entity
{

	private static final long serialVersionUID = 1L;
	private static final String FACULTY_ENTITY_PATH = ENTITY_PATH + "course/";
	
	private Integer id;
	private String facultyId;
	private String facultyName;
	private String institution;
	private String title;
	private String position;
	private String introduction;
	private String image;
	
	private Set<Course> course = new HashSet<Course>();
	private User user;
	
	public Faculty()
	{
		
	}

	public Faculty(Integer id, String facultyId, String facultyName, String institution, String title, String position,
			String introduction, Set<Course> course, User user)
	{
		this.id = id;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.institution = institution;
		this.title = title;
		this.position = position;
		this.introduction = introduction;
		this.course = course;
		this.user = user;
	}

	public String getFacultyName() 
	{
		return facultyName;
	}

	public void setFacultyName(String facultyName) 
	{
		this.facultyName = facultyName;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public String getInstitution()
	{
		return institution;
	}

	public void setInstitution(String institution)
	{
		this.institution = institution;
	}


	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFacultyId()
	{
		return facultyId;
	}

	public void setFacultyId(String facultyId)
	{
		this.facultyId = facultyId;
	}

	public String getIntroduction()
	{
		return introduction;
	}

	public void setIntroduction(String introduction)
	{
		this.introduction = introduction;
	}

	public Set<Course> getCourse()
	{
		return course;
	}

	public void setCourse(Set<Course> course)
	{
		this.course = course;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String findPath()
	{
		if(id == null)
			return null;
		return FACULTY_ENTITY_PATH + "Faculty" + getFacultyId();
	}
	
	public static Faculty toJson(Faculty faculty)
	{
		Faculty tempFaculty = null;
		try
		{
			tempFaculty = (Faculty) faculty.clone();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Faculty jsonFaculty = faculty;
		jsonFaculty.user = new User();
		if(tempFaculty.getUser() != null)
			jsonFaculty.user.setId(tempFaculty.getUser().getId());
		jsonFaculty.course = new HashSet<Course>();
		for(Course facultyCourse : tempFaculty.getCourse())
		{
			Course course = new Course(facultyCourse.getId());
			jsonFaculty.course.add(course);
		}
		return jsonFaculty;
	}

}
