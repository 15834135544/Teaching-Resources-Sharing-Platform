package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.Entity;

public interface INaturalNameTransaction<TEntity extends Entity>
{
	public List<TEntity> findByNaturalName(TEntity entity);
	public List<TEntity> findByNaturalNameByPage(TEntity entity, Integer count, Integer page);
	public List<TEntity> findByNaturalNames(TEntity entities[]);
	public List<TEntity> findByNaturalNamesByPage(TEntity entities[], Integer count, Integer page);
}
