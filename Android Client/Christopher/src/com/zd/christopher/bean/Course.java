package com.zd.christopher.bean;


import java.util.HashSet;
import java.util.Set;
/*
 * 	Course - Faculty 	* - 1
 * 	Course - Student 	* - *
 * 	Course - Document 	1 - *
 * 	Course - Video		1 - *
 *  Course - Administrator * - *
 *  Course - User		* - * 
 * 
 */
public class Course extends Entity
{
	private static final long serialVersionUID = 1L;
	private static final String COURSE_ENTITY_PATH = ENTITY_PATH + "course/";
	
	private Integer id;	
	private String courseId;	
	private String courseName;
	private Double credit;
	private String semester;
	private Double period;
	private String introduction;
	private String image;
	
	private Faculty faculty;
	private Set<Student> student = new HashSet<Student>();
	private Set<Document> document = new HashSet<Document>();
	private Set<Video> video = new HashSet<Video>();
	private Set<Administrator> administrator = new HashSet<Administrator>();
	private Set<User> favorUser = new HashSet<User>();

	
	public Course()
	{
		
	}
	
	public Course(Integer id)
	{
		this.id = id;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public Set<User> getFavorUser()
	{
		return favorUser;
	}

	public void setFavorUser(Set<User> favorUser)
	{
		this.favorUser = favorUser;
	}

	public Set<Administrator> getAdministrator()
	{
		return administrator;
	}


	public void setAdministrator(Set<Administrator> administrator)
	{
		this.administrator = administrator;
	}

	public Set<Student> getStudent()
	{
		return student;
	}


	public void setStudent(Set<Student> student)
	{
		this.student = student;
	}


	public String getIntroduction()
	{
		return introduction;
	}


	public void setIntroduction(String introduction)
	{
		this.introduction = introduction;
	}


	public Set<Document> getDocument()
	{
		return document;
	}


	public void setDocument(Set<Document> document)
	{
		this.document = document;
	}


	public Set<Video> getVideo()
	{
		return video;
	}


	public void setVideo(Set<Video> video)
	{
		this.video = video;
	}


	public Faculty getFaculty()
	{
		return faculty;
	}


	public void setFaculty(Faculty faculty)
	{
		this.faculty = faculty;
	}


	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	
	public Double getCredit()
	{
		return credit;
	}
	
	public void setCredit(Double credit) 
	{
		this.credit = credit;
	}
	
	public String getSemester() 
	{
		return semester;
	}
	
	public void setSemester(String semester)
	{
		this.semester = semester;
	}
	
	public Double getPeriod() 
	{
		return period;
	}
	
	public void setPeriod(Double period)
	{
		this.period = period;
	}

	public String getCourseId()
	{
		return courseId;
	}

	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}

	
	public String getCourseName() 
	{
		return courseName;
	}

	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}

	public String findPath() 
	{
		if(id == null)
			return null;
		return COURSE_ENTITY_PATH + "Course" + getCourseId();
	}

	public static Course toJson(Course course)
	{
		Course tempCourse = null;
		try
		{
			tempCourse = (Course) course.clone();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Course jsonCourse = course;
		jsonCourse.faculty = new Faculty();
		if(tempCourse.getFaculty() != null)
			jsonCourse.setId(tempCourse.getFaculty().getId());
		jsonCourse.administrator = new HashSet<Administrator>();
		jsonCourse.document = new HashSet<Document>();
		jsonCourse.favorUser = new HashSet<User>();
		jsonCourse.student = new HashSet<Student>();
		jsonCourse.video = new HashSet<Video>();
		for(Administrator chargedAdministrator : tempCourse.getAdministrator())
		{
			Administrator administrator = new Administrator(chargedAdministrator.getId());
			jsonCourse.administrator.add(administrator);
		}
		for(Document courseDocument : tempCourse.getDocument())
		{
			Document document = new Document(courseDocument.getId());
			jsonCourse.document.add(document);
		}
		for(User favorUser : tempCourse.getFavorUser())
		{
			User user = new User(favorUser.getId());
			jsonCourse.favorUser.add(user);
		}
		for(Student courseStudent : tempCourse.getStudent())
		{
			Student student = new Student(courseStudent.getId());
			jsonCourse.student.add(student);
		}
		for(Video courseVideo : tempCourse.getVideo())
		{
			Video video = new Video(courseVideo.getId());
			jsonCourse.video.add(video);
		}
		return jsonCourse;
	}
}
