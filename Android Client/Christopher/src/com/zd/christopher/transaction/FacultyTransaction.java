package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.Faculty;

public class FacultyTransaction extends BaseTransaction<Faculty> implements IFacultyTransaction
{
	public FacultyTransaction()
	{
		entityClass = Faculty.class;
	}

	public Faculty findByNaturalId(Faculty entity)
	{
		return null;
	}

	public List<Faculty> findByNaturalIds(Faculty[] entities)
	{
		return null;
	}

	public List<Faculty> findByNaturalIdsByPage(Faculty[] entities, Integer count, Integer page)
	{
		return null;
	}

	public List<Faculty> findByNaturalName(Faculty entity)
	{
		return null;
	}

	public List<Faculty> findByNaturalNameByPage(Faculty entity, Integer count, Integer page)
	{	
		return null;
	}

	public List<Faculty> findByNaturalNames(Faculty[] entities)
	{
		return null;
	}
	
	public List<Faculty> findByNaturalNamesByPage(Faculty[] entities, Integer count, Integer page)
	{	
		return null;
	}
}
