package com.zd.christopher.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.Entity;
@Repository
@Scope("prototype")
public class NaturalNameDAO<TEntity extends Entity> implements INaturalNameDAO<TEntity>
{
	@Resource
	SessionFactory sessionFactory;
	private Class<TEntity> entityClass;
	
	public Class<TEntity> getEntityClass()
	{
		return entityClass;
	}

	public void setEntityClass(Class<TEntity> entityClass)
	{
		this.entityClass = entityClass;
	}
	
	public List<TEntity> findByNaturalName(String naturalName)
	{
		Session session = sessionFactory.getCurrentSession();
		List<TEntity> entityList = session.createQuery(
				 				   "from " + entityClass.getSimpleName() + " where " + entityClass.getSimpleName().toLowerCase() + "Name = :naturalName")
				 				   .setParameter("naturalName", naturalName)
				 				   .list();
		return entityList;
	}

	public List<TEntity> findByNaturalNameByPage(String naturalName, Integer count, Integer page)
	{
		Session session = sessionFactory.getCurrentSession();
		int index = count * (page -1);
    	List<TEntity> entityList = session.createQuery(
    					 "from " + entityClass.getSimpleName() + " where " + entityClass.getSimpleName().toLowerCase() + "Name = :naturalName")
    					 .setFirstResult(index)
    					 .setMaxResults(count)
    					 .setParameter("naturalName", naturalName)
    					 .list();
		return entityList;
	}

	public List<TEntity> findByNaturalNames(String[] naturalNames)
	{
		Session session = sessionFactory.getCurrentSession();
    	List<TEntity> entityList = session.createQuery(
    					 "from " + entityClass.getSimpleName() + " where " + entityClass.getSimpleName().toLowerCase() + "Name in (:naturalNames)")
    					 .setParameter("naturalNames", naturalNames)
    					 .list();
		return entityList;
	}

	public List<TEntity> findByNaturalNamesByPage(String[] naturalNames, Integer count, Integer page)
	{
		Session session = sessionFactory.getCurrentSession();
    	List<TEntity> entityList = session.createQuery(
    					 "from " + entityClass.getSimpleName() + " where " + entityClass.getSimpleName().toLowerCase() + "Name in (:naturalNames)")
    					 .setParameter("naturalNames", naturalNames)
    					 .list();
		return entityList;
	}
}
