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
public class NaturalIdDAO<TEntity extends Entity> implements INaturalIdDAO<TEntity>
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

	public TEntity findByNaturalId(String naturalId)
	{
		Session session = sessionFactory.getCurrentSession();
		TEntity entity = (TEntity) session.createQuery(
				 	     "from " + entityClass.getSimpleName() + " where " + entityClass.getSimpleName().toLowerCase() + "Id = :naturalId")
				 	     .setParameter("naturalId", naturalId)
				 	     .uniqueResult();
		return entity;
	}

	public List<TEntity> findByNaturalIds(String[] naturalIds)
	{
		Session session = sessionFactory.getCurrentSession();
		List<TEntity> entityList = session.createQuery(
				   				   "from " + entityClass.getSimpleName() + " where " + entityClass.getSimpleName().toLowerCase() + "Id in (:naturalIds)")
				   				   .setParameter("naturalIds", naturalIds)
				   				   .list();
		return entityList;
	}

	public List<TEntity> findByNaturalIdsByPage(String[] naturalIds, Integer count, Integer page)
	{
		Session session = sessionFactory.getCurrentSession();
		int index = count * (page -1);
    	List<TEntity> entityList = session.createQuery(
    						   "from " + entityClass.getSimpleName() + " where " + entityClass.getSimpleName().toLowerCase() + "Id in (:naturalIds)")
    						   .setFirstResult(index)
    						   .setMaxResults(count)
    						   .setParameter("naturalIds", naturalIds)
    						   .list();
		return entityList;
	}
}
