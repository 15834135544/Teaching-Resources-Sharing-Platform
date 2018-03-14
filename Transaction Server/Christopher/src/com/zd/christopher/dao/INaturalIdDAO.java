package com.zd.christopher.dao;

import java.util.List;

import com.zd.christopher.bean.Entity;

public interface INaturalIdDAO<TEntity extends Entity>
{
	public TEntity findByNaturalId(String naturalId);
	public List<TEntity> findByNaturalIds(String[] naturalIds);
	public List<TEntity> findByNaturalIdsByPage(String[] naturalIds, Integer count, Integer page);
}
