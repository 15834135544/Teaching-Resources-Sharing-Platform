package com.zd.christopher.dao;

import java.util.List;

import com.zd.christopher.bean.Entity;

public interface IEntityDAO<TEntity extends Entity>
{
	public void add(TEntity entity);
	public void update(TEntity entity);
	public void delete(Integer id);
	public TEntity find(Integer id);
	public List<TEntity> findByIds(Integer[] ids);
	public List<TEntity> findByIdsByPage(Integer[] id, Integer count, Integer page);
	public List<TEntity> findAll();	
	public Long countAll();
}
