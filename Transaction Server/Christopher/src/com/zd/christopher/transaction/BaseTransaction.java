package com.zd.christopher.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.dao.EntityDAO;
import com.zd.christopher.reflector.Reflector;
@Service
public class BaseTransaction<TEntity extends Entity> implements IBaseTransaction<TEntity>
{
	@Resource
	private EntityDAO<TEntity> entityDAO;
	protected Class<TEntity> entityClass;
	
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
		entityDAO.add(entity);
	}
	
	public void update(TEntity entity)
	{
		entityDAO.update(entity);
	}

	public void delete(TEntity entity)
	{
		entityDAO.setEntityClass((Class<TEntity>) entity.getClass());
		Integer id = (Integer) Reflector.getFieldValue(entity, "id");
		entityDAO.delete(id);
	}

	public TEntity find(TEntity entity)
	{
		entityDAO.setEntityClass((Class<TEntity>) entity.getClass());
		Integer id = (Integer) Reflector.getFieldValue(entity, "id");
		return entityDAO.find(id);
	}
	
	public List<TEntity> findAll()
	{
		entityDAO.setEntityClass(getEntityClass());
		return entityDAO.findAll();
	}
	
	public Long countAll()
	{
		entityDAO.setEntityClass(getEntityClass());
		return entityDAO.countAll();
	}

	public List<TEntity> findByIds(List<TEntity> entityList)
	{
		entityDAO.setEntityClass(getEntityClass());
		List<Integer> idList = new ArrayList<Integer>();
		for(TEntity entity : entityList)
			idList.add((Integer) Reflector.getFieldValue(entity, "id"));
		return entityDAO.findByIds((Integer[]) idList.toArray());
	}

	public List<TEntity> findByIdsByPage(List<TEntity> entityList, Integer count, Integer page)
	{
		entityDAO.setEntityClass(getEntityClass());
		List<Integer> idList = new ArrayList<Integer>();
		for(TEntity entity : entityList)
			idList.add((Integer) Reflector.getFieldValue(entity, "id"));
		return entityDAO.findByIdsByPage((Integer[]) idList.toArray(), count, page);
	}
}
