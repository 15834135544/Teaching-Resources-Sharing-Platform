package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.Entity;

public abstract class BaseTransaction<TEntity extends Entity> implements IBaseTransaction<TEntity>
{
	protected Class<TEntity> entityClass;
	protected static final String URL = "http://192.168.1.104:8181/Christopher/";
	
	public Class<TEntity> getEntityClass()
	{
		return entityClass;
	}

	public void setEntityClass(Class<TEntity> entityClass)
	{
		this.entityClass = entityClass;
	}

	public void add(TEntity entity)
	{

	}
	
	public void update(TEntity entity)
	{

	}

	public void delete(TEntity entity)
	{

	}

	public TEntity find(TEntity entity)
	{
		return null;
	}

	public List<TEntity> findByIds(List<TEntity> entityList)
	{
		return null;
	}

	public List<TEntity> findByIdsByPage(List<TEntity> entityList, Integer count, Integer page)
	{
		return null;
	}
}
