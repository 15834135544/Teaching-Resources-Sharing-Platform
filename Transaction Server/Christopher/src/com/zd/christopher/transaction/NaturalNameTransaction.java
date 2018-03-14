package com.zd.christopher.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.dao.NaturalNameDAO;
import com.zd.christopher.reflector.Reflector;
@Service
@Scope("prototype")
public class NaturalNameTransaction<TEntity extends Entity> implements INaturalNameTransaction<TEntity>
{
	@Resource
	private NaturalNameDAO<TEntity> naturalNameDAO;
	private Class<TEntity> entityClass;
	
	public Class<TEntity> getEntityClass()
	{
		return entityClass;
	}
	
	public void setEntityClass(Class<TEntity> entityClass)
	{
		this.entityClass = entityClass;
	}
	
	private void setParams()
	{
		naturalNameDAO.setEntityClass(entityClass);
	}

	public List<TEntity> findByNaturalName(TEntity entity)
	{
		setParams();
		return naturalNameDAO.findByNaturalName((String) Reflector.getFieldValue(entity, entityClass.getSimpleName().toLowerCase() + "Name"));
	}

	public List<TEntity> findByNaturalNameByPage(TEntity entity, Integer count, Integer page)
	{
		
		setParams();
		return naturalNameDAO.findByNaturalNameByPage((String) Reflector.getFieldValue(entity, entityClass.getSimpleName().toLowerCase() + "Name"), count, page);
	}

	public List<TEntity> findByNaturalNames(TEntity[] entities)
	{
		setParams();
		List<String> naturalNameList = new ArrayList<String>();
		for(TEntity entity : entities)
			naturalNameList.add((String) Reflector.getFieldValue(entity, entityClass.getSimpleName().toLowerCase() + "Name"));
		return naturalNameDAO.findByNaturalNames((String[]) naturalNameList.toArray());
	}

	public List<TEntity> findByNaturalNamesByPage(TEntity[] entities, Integer count, Integer page)
	{
		setParams();
		List<String> naturalNameList = new ArrayList<String>();
		for(TEntity entity : entities)
			naturalNameList.add((String) Reflector.getFieldValue(entity, entityClass.getSimpleName().toLowerCase() + "Name"));
		return naturalNameDAO.findByNaturalNamesByPage((String[]) naturalNameList.toArray(), count, page);
	}

}
