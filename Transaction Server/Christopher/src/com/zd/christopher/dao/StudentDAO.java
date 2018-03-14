package com.zd.christopher.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.Student;
@Repository
public class StudentDAO extends EntityDAO<Student> implements IStudentDAO
{
	@PostConstruct
	public void init()
	{
		entityClass = Student.class;
	}

	public Student findByNaturalId(String id)
	{	
		return null;
	}
	
	public List<Student> findByNaturalIds(String[] ids)
	{
		return null;
	}

	public List<Student> findByNaturalIdsByPage(String[] ids, Integer count, Integer page)
	{
		return null;
	}

	public List<Student> findByNaturalName(String name)
	{	
		return null;
	}

	public List<Student> findByNaturalNameByPage(String name, Integer count, Integer page)
	{
		return null;
	}

	public List<Student> findByNaturalNames(String[] name)
	{
		return null;
	}

	public List<Student> findByNaturalNamesByPage(String[] name, Integer count, Integer page)
	{
		return null;
	}

	public boolean updateCourse(Student student)
	{
		return false;
	}
}
