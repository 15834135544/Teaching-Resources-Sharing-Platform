package com.zd.christopher.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.Faculty;
@Repository
public class FacultyDAO extends EntityDAO<Faculty> implements IFacultyDAO
{
	@PostConstruct
	public void init()
	{
		entityClass = Faculty.class;
	}

	public Faculty findByNaturalId(String id)
	{
		return null;
	}

	public List<Faculty> findByNaturalIds(String[] ids)
	{		
		return null;
	}

	public List<Faculty> findByNaturalIdsByPage(String[] ids, Integer count, Integer page)
	{
		return null;
	}

	public List<Faculty> findByNaturalName(String name)
	{	
		return null;
	}

	public List<Faculty> findByNaturalNameByPage(String name, Integer count, Integer page)
	{
		return null;
	}

	public List<Faculty> findByNaturalNames(String[] name)
	{
		return null;
	}

	public List<Faculty> findByNaturalNamesByPage(String[] name, Integer count, Integer page)
	{
		return null;
	}
}
