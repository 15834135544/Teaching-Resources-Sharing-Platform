package com.zd.christopher.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.transaction.NaturalIdTransaction;
@Controller
@Scope("prototype")
public class NaturalIdAction<TEntity extends Entity>
{
	@Resource
	private NaturalIdTransaction<TEntity> naturalIdTransaction;
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
		naturalIdTransaction.setEntityClass(entityClass);
	}

	public TEntity findByNaturalId(TEntity entity)
	{
		setParams();
		return naturalIdTransaction.findByNaturalId(entity);	
	}

	public List<TEntity> findByNaturalIds(TEntity[] entities)
	{
		setParams();
		return naturalIdTransaction.findByNaturalIds(entities);
	}

	public List<TEntity> findByNaturalIdsByPage(TEntity[] entities, Integer count, Integer page)
	{
		setParams();
		return naturalIdTransaction.findByNaturalIdsByPage(entities, count, page);
	}
	
}
