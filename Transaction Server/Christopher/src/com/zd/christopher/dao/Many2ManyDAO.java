package com.zd.christopher.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.reflector.Reflector;
@Repository
@Scope("prototype")
public class Many2ManyDAO<TEntity extends Entity>
{
	@Resource
	SessionFactory sessionFactory;
	private String updatedField;
	private Class<TEntity> entityClass;

	public String getUpdatedField()
	{
		return updatedField;
	}

	public void setUpdatedField(String updatedField)
	{
		this.updatedField = updatedField;
	}

	public Class<TEntity> getEntityClass()
	{
		return entityClass;
	}

	public void setEntityClass(Class<TEntity> entityClass)
	{
		this.entityClass = entityClass;
	}

	public boolean update(TEntity entity)
	{
    	Session session = sessionFactory.getCurrentSession();
    	TEntity updatedEntity = (TEntity) session.get(entityClass, (Integer) Reflector.getFieldValue(entity, "id"));
    	Reflector.replaceCollection(entity, updatedEntity, updatedField);
    	return true;
	}
}
