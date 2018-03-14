package com.zd.christopher.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Course;
import com.zd.christopher.dao.ICourseDAO;
@Service
public class CourseTransaction extends BaseTransaction<Course> implements ICourseTransaction
{
	@Resource
	private ICourseDAO courseDAO;
	
	@PostConstruct
	public void init()
	{
		entityClass = Course.class;
	}

	public Course findByNaturalId(Course entity)
	{
		return courseDAO.findByNaturalId(entity.getCourseId());
	}

	public List<Course> findByNaturalIds(Course[] entities)
	{
		List<String> idList = new ArrayList<String>();
		for(Course course : entities)
			idList.add(course.getCourseId());
		return courseDAO.findByNaturalIds((String[]) idList.toArray());
	}

	public List<Course> findByNaturalIdsByPage(Course[] entities, Integer count, Integer page)
	{
		List<String> idList = new ArrayList<String>();
		for(Course course : entities)
			idList.add(course.getCourseId());
		return courseDAO.findByNaturalIdsByPage((String[]) idList.toArray(), count, page);
	}

	public List<Course> findByNaturalName(Course entity)
	{
		return courseDAO.findByNaturalName(entity.getCourseName());
	}

	public List<Course> findByNaturalNameByPage(Course entity, Integer count, Integer page)
	{	
		return courseDAO.findByNaturalNameByPage(entity.getCourseName(), count, page);
	}

	public List<Course> findByNaturalNames(Course[] entities)
	{
		List<String> nameList = new ArrayList<String>();
		for(Course course : entities)
			nameList.add(course.getCourseName());
		return courseDAO.findByNaturalNames((String[]) nameList.toArray());
	}
	
	public List<Course> findByNaturalNamesByPage(Course[] entities, Integer count, Integer page)
	{	
		List<String> nameList = new ArrayList<String>();
		for(Course course : entities)
			nameList.add(course.getCourseName());
		return courseDAO.findByNaturalNamesByPage((String[]) nameList.toArray(), count, page);
	}
}
