package com.zd.christopher.bean;


import java.util.HashSet;
import java.util.Set;
/*
 * 	Student - Course	* - *
 * 	Student - User		1 - 1
 */
public class Student extends Entity
{
	private static final long serialVersionUID = 1L;
	private static final String STUDENT_ENTITY_PATH = ENTITY_PATH + "student/";
	
	private Integer id;
	private String studentId;
	private String studentName;
	private String institution;
	private String title;
	private String position;
	
	private Set<Course> course = new HashSet<Course>();
	private User user;
	
	public Student()
	{
		
	}
	
	public Student(Integer id)
	{
		this.id = id;
	}

	public Student(Integer id, String studentId, String studentName, String institution, String title, String position,
			Set<Course> course, User user)
	{
		this.id = id;
		this.studentId = studentId;
		this.studentName = studentName;
		this.institution = institution;
		this.title = title;
		this.position = position;
		this.course = course;
		this.user = user;
	}

	public String getStudentId()
	{
		return studentId;
	}

	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}

	public Integer getId() {
		return id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setId(Integer id)
	{
		this.id = id;
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

	public String getPosition()
	{
		return position;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public String findPath()
	{
		if(id == null)
			return null;
		return STUDENT_ENTITY_PATH + "student" + getStudentId();
	}
	
	public static Student toJson(Student student)
	{
		Student tempStudent = null;
		try
		{
			tempStudent = (Student) student.clone();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Student jsonStudent = student;
		jsonStudent.user = new User();
		if(tempStudent.getUser() != null)
			jsonStudent.user.setId(tempStudent.getUser().getId());
		jsonStudent.course = new HashSet<Course>();
		for(Course studentCourse : tempStudent.getCourse())
		{
			Course course = new Course(studentCourse.getId());
			jsonStudent.course.add(course);
		}
		return jsonStudent;
	}

}
