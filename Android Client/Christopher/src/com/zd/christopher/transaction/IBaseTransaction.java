package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.Entity;

public interface IBaseTransaction<TEntity extends Entity>
{
	public void add(TEntity entity);
	public void update(TEntity entity);
	public void delete(TEntity entity);
	public TEntity find(TEntity entity);
	public List<TEntity> findByIds(List<TEntity> entityList);
	public List<TEntity> findByIdsByPage(List<TEntity> entityList,Integer count, Integer page);
}
