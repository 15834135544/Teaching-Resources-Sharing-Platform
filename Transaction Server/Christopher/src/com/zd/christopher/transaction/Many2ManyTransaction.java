package com.zd.christopher.transaction;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.dao.Many2ManyDAO;

@Service
@Scope("prototype")
public class Many2ManyTransaction<TEntity extends Entity>
{
	@Resource
	private Many2ManyDAO<TEntity> many2ManyDAO;
	private String updatedField;
	private Class<TEntity> entityClass;
	
	public String getUpdatedField()
	{
		return updatedField;
	}

	public Class<TEntity> getEntityClass()
	{
		return entityClass;
	}

	public void setUpdatedField(String updatedField)
	{
		this.updatedField = updatedField;
	}

	public void setEntityClass(Class<TEntity> entityClass)
	{
		this.entityClass = entityClass;
	}
	
	private void setParams()
	{
		many2ManyDAO.setUpdatedField(updatedField);
		many2ManyDAO.setEntityClass(entityClass);
	}

	public boolean update(TEntity entity)
	{
		setParams();
		many2ManyDAO.update(entity);
		return true;
	}
}
