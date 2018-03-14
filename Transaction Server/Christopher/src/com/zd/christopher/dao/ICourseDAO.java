package com.zd.christopher.dao;

import com.zd.christopher.bean.Course;


public interface ICourseDAO extends IEntityDAO<Course>, INaturalIdDAO<Course>, INaturalNameDAO<Course>
{
	public boolean updateFaculty(Course course);
}
