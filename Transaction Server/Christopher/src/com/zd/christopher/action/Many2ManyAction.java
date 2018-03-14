package com.zd.christopher.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.transaction.Many2ManyTransaction;
@Controller
@Scope("prototype")
public class Many2ManyAction<TEntity extends Entity>
{
	@Resource
	private Many2ManyTransaction<TEntity> many2ManyTransaction;
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
	
	private void setParams()
	{
		many2ManyTransaction.setUpdatedField(updatedField);
		many2ManyTransaction.setEntityClass(entityClass);
	}
	
	public boolean update(TEntity entity)
	{
		setParams();
		many2ManyTransaction.update(entity);
		return true;
	}
}
