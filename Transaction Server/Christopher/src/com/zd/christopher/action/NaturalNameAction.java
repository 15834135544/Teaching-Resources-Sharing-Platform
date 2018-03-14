package com.zd.christopher.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.transaction.NaturalNameTransaction;
@Controller
@Scope("prototype")
public class NaturalNameAction<TEntity extends Entity>
{
	@Resource
	private NaturalNameTransaction<TEntity> naturalNameTransaction;
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
		naturalNameTransaction.setEntityClass(entityClass);
	}

	
	public List<TEntity> findByNaturalName(TEntity entity)
	{
		setParams();
		return naturalNameTransaction.findByNaturalName(entity);
	}

	public List<TEntity> findByNaturalNameByPage(TEntity entity, Integer count, Integer page)
	{
		setParams();
		return naturalNameTransaction.findByNaturalNameByPage(entity, count, page);
	}

	public List<TEntity> findByNaturalNames(TEntity[] entities)
	{
		setParams();
		return naturalNameTransaction.findByNaturalNames(entities);
	}

	public List<TEntity> findByNaturalNamesByPage(TEntity[] entities, Integer count, Integer page)
	{
		setParams();
		return naturalNameTransaction.findByNaturalNamesByPage(entities, count, page);
	}

}
