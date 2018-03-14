package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.Entity;

public interface INaturalIdTransaction<TEntity extends Entity>
{
	public TEntity findByNaturalId(TEntity entity);
	public List<TEntity> findByNaturalIds(TEntity entities[]);
	public List<TEntity> findByNaturalIdsByPage(TEntity entities[],Integer count, Integer page);
}
