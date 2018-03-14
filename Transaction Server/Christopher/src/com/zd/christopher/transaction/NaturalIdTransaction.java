package com.zd.christopher.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.dao.NaturalIdDAO;
import com.zd.christopher.reflector.Reflector;
@Service
@Scope("prototype")
public class NaturalIdTransaction<TEntity extends Entity> implements INaturalIdTransaction<TEntity>
{
	@Resource
	private NaturalIdDAO<TEntity> naturalIdDAO;
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
		naturalIdDAO.setEntityClass(entityClass);
	}

	public TEntity findByNaturalId(TEntity entity)
	{
		setParams();
		return naturalIdDAO.findByNaturalId((String) Reflector.getFieldValue(entity, entityClass.getSimpleName().toLowerCase() + "Id"));
	}

	public List<TEntity> findByNaturalIds(TEntity[] entities)
	{
		setParams();
		List<String> naturalIdList = new ArrayList<String>();
		for(TEntity entity : entities)
			naturalIdList.add((String) Reflector.getFieldValue(entity, entityClass.getSimpleName().toLowerCase() + "Id"));
		return naturalIdDAO.findByNaturalIds((String[]) naturalIdList.toArray());
	}

	public List<TEntity> findByNaturalIdsByPage(TEntity[] entities, Integer count, Integer page)
	{
		setParams();
		List<String> naturalIdList = new ArrayList<String>();
		for(TEntity entity : entities)
			naturalIdList.add((String) Reflector.getFieldValue(entity, entityClass.getSimpleName().toLowerCase() + "Id"));
		return naturalIdDAO.findByNaturalIdsByPage((String[]) naturalIdList.toArray(), count, page);
	}
	
}
