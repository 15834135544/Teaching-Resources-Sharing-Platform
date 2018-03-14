package com.zd.christopher.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.reflector.Reflector;
@Repository
public class EntityDAO<TEntity extends Entity> implements IEntityDAO<TEntity>
{
	@Resource
	private SessionFactory sessionFactory;
	protected Class<TEntity> entityClass;
	
	public void setEntityClass(Class<TEntity> entityClass)
	{
		this.entityClass = entityClass;
	}

	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public Class<TEntity> getEntityClass()
	{
		return entityClass;
	}

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public void add(TEntity entity) 
	{
		Session session = getSession();
		session.save(entity);
	}

	public void update(TEntity entity) 
	{
		Session session = getSession();
		Integer id = (Integer) Reflector.getFieldValue(entity, "id");
		TEntity updatedEntity = (TEntity) session.get(entityClass, id);
		Reflector.mergePOJOs(entity, updatedEntity);
	}

	public void delete(Integer id) 
	{
		Session session = getSession();
		TEntity entity = (TEntity) session.get(entityClass, id);
		session.delete(entity);
	}

	public List<TEntity> findAll()
	{
		Session session = getSession();
		List<TEntity> entityList = session.createQuery(
				"from "+entityClass.getSimpleName())
				.list();
		return entityList;
	}

	public TEntity find(Integer id) 
	{
		Session session = getSession();
		TEntity entity = (TEntity) session.get(entityClass.getName(), id);
		return entity;
	}
	
	public List<TEntity> findByIdsByPage(Integer[] ids, Integer count, Integer page)
	{
		Session session = getSession();
		int index = count * (page -1);
		List<TEntity> entityList = session.createQuery(
				    			   "from " + entityClass.getSimpleName() + " where id in (:ids)")
				    			   .setFirstResult(index)
				    			   .setMaxResults(count)
				    			   .setParameter("ids", ids)
				    			   .list();
		return entityList;
	}

	public List<TEntity> findByIds(Integer[] ids) 
	{
		Session session = getSession();	
		List<TEntity> entityList = session.createQuery(
								   "from " + entityClass.getSimpleName() + " where id in (:ids)")
								   .setParameterList("ids", ids)
								   .list();
		return entityList;
	}
	
	public Long countAll()
	{
		Session session = getSession();
		Long count = (Long) session.createQuery(
		   			 "select count(*) from " + entityClass.getSimpleName())
				     .uniqueResult();
		return count;
	}
}
