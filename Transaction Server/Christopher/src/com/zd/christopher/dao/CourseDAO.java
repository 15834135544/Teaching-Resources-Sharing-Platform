package com.zd.christopher.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.Course;

@Repository
public class CourseDAO extends EntityDAO<Course> implements ICourseDAO
{
	@PostConstruct
	public void init()
	{
		entityClass = Course.class;
	}

	public Course findByNaturalId(String id)
	{
		return null;
	}

	public List<Course> findByNaturalIds(String[] ids)
	{	
		return null;
	}
	
	public List<Course> findByNaturalIdsByPage(String[] ids, Integer count, Integer page)
	{
		return null;
	}

	public List<Course> findByNaturalName(String name)
	{
		return null;
	}

	public List<Course> findByNaturalNameByPage(String name, Integer count, Integer page)
	{	
		return null;
	}

	public List<Course> findByNaturalNames(String[] name)
	{
		return null;
	}

	public List<Course> findByNaturalNamesByPage(String[] name, Integer count, Integer page)
	{
		return null;
	}

	public boolean updateFaculty(Course course)
	{
		return false;
	}
}
