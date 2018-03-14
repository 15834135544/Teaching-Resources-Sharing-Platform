package com.zd.christopher.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Faculty;
import com.zd.christopher.dao.IFacultyDAO;
@Service
public class FacultyTransaction extends BaseTransaction<Faculty> implements IFacultyTransaction
{
	@Resource
	private IFacultyDAO facultyDAO;
	
	@PostConstruct
	public void init()
	{
		entityClass = Faculty.class;
	}

	public Faculty findByNaturalId(Faculty entity)
	{
		return facultyDAO.findByNaturalId(entity.getFacultyId());
	}

	public List<Faculty> findByNaturalIds(Faculty[] entities)
	{
		List<String> idList = new ArrayList<String>();
		for(Faculty faculty : entities)
			idList.add(faculty.getFacultyId());
		return facultyDAO.findByNaturalIds((String[]) idList.toArray());
	}

	public List<Faculty> findByNaturalIdsByPage(Faculty[] entities, Integer count, Integer page)
	{
		List<String> idList = new ArrayList<String>();
		for(Faculty faculty : entities)
			idList.add(faculty.getFacultyId());
		return facultyDAO.findByNaturalIdsByPage((String[]) idList.toArray(), count, page);
	}

	public List<Faculty> findByNaturalName(Faculty entity)
	{
		return facultyDAO.findByNaturalName(entity.getFacultyName());
	}

	public List<Faculty> findByNaturalNameByPage(Faculty entity, Integer count, Integer page)
	{	
		return facultyDAO.findByNaturalNameByPage(entity.getFacultyName(), count, page);
	}

	public List<Faculty> findByNaturalNames(Faculty[] entities)
	{
		List<String> nameList = new ArrayList<String>();
		for(Faculty faculty : entities)
			nameList.add(faculty.getFacultyName());
		return facultyDAO.findByNaturalNames((String[]) nameList.toArray());
	}
	
	public List<Faculty> findByNaturalNamesByPage(Faculty[] entities, Integer count, Integer page)
	{	
		List<String> nameList = new ArrayList<String>();
		for(Faculty faculty : entities)
			nameList.add(faculty.getFacultyName());
		return facultyDAO.findByNaturalNamesByPage((String[]) nameList.toArray(), count, page);
	}
}
