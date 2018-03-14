package com.zd.christopher.dao;

import java.util.List;

import com.zd.christopher.bean.Entity;

public interface INaturalNameDAO<TEntity extends Entity>
{
	public List<TEntity> findByNaturalName(String naturalName);
	public List<TEntity> findByNaturalNameByPage(String naturalName, Integer count, Integer page);
	public List<TEntity> findByNaturalNames(String[] naturalNames);
	public List<TEntity> findByNaturalNamesByPage(String[] naturalNames, Integer count, Integer page);
}
