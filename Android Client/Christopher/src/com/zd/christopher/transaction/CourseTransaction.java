package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.Course;

public class CourseTransaction extends BaseTransaction<Course> implements ICourseTransaction
{

	public CourseTransaction()
	{
		entityClass = Course.class;
	}

	public Course findByNaturalId(Course entity)
	{
		return null;
	}

	public List<Course> findByNaturalIds(Course[] entities)
	{
		return null;
	}

	public List<Course> findByNaturalIdsByPage(Course[] entities, Integer count, Integer page)
	{
		return null;
	}

	public List<Course> findByNaturalName(Course entity)
	{
		return null;
	}

	public List<Course> findByNaturalNameByPage(Course entity, Integer count, Integer page)
	{	
		return null;
	}

	public List<Course> findByNaturalNames(Course[] entities)
	{
		return null;
	}
	
	public List<Course> findByNaturalNamesByPage(Course[] entities, Integer count, Integer page)
	{	
		return null;
	}
}
