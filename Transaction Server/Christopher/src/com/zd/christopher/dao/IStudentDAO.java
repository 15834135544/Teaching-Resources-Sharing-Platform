package com.zd.christopher.dao;

import com.zd.christopher.bean.Student;


public interface IStudentDAO extends IEntityDAO<Student>, INaturalIdDAO<Student>, INaturalNameDAO<Student>
{
	public boolean updateCourse(Student student);
}
