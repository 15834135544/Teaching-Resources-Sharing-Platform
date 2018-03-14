package com.zd.christopher.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.Video;
@Repository
public class VideoDAO extends EntityDAO<Video> implements IVideoDAO
{
	@PostConstruct
	public void init()
	{
		entityClass = Video.class;
	}

	public List<Video> findByNaturalName(String name)
	{
		return null;
	}

	public List<Video> findByNaturalNameByPage(String name, Integer count, Integer page)
	{
		return null;
	}

	public List<Video> findByNaturalNames(String[] name)
	{
		return null;
	}

	public List<Video> findByNaturalNamesByPage(String[] name, Integer count, Integer page)
	{
		return null;
	}

	public boolean updateCourse(Video video)
	{	
		return false;
	}

	public boolean updateUser(Video video)
	{	
		return false;
	}
	public boolean updateFavorUser(Video video)
	{
		return false;
	}
}
