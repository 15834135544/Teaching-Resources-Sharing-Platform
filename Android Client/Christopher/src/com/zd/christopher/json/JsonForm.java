package com.zd.christopher.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.zd.christopher.bean.Entity;

public class JsonForm<TEntity extends Entity>
{
	private List<TEntity> entityList;
	private Integer count;
	private Integer page;
	
	public JsonForm()
	{
		
	}
	
	public JsonForm(List<TEntity> entityList)
	{
		this.entityList = entityList;
	}
	
	public JsonForm(List<TEntity> entityList, Integer count, Integer page)
	{
		this.entityList = entityList;
		this.count = count;
		this.page = page;
	}
	
	public JsonForm(TEntity entity)
	{
		this.entityList = new ArrayList<TEntity>();
		entityList.add(entity);
	}
	
	public List<TEntity> getEntityList()
	{
		return entityList;
	}
	
	public Integer getCount()
	{
		return count;
	}
	
	public Integer getPage()
	{
		return page;
	}
	
	public void setEntityList(List<TEntity> entityList)
	{
		this.entityList = entityList;
	}
	
	public void setCount(Integer count)
	{
		this.count = count;
	}
	
	public void setPage(Integer page)
	{
		this.page = page;
	}
	
	public static <TEntity extends Entity> String constructJsonForm(List<TEntity> entityList, Integer count, Integer page)
	{
		JsonForm<TEntity> jsonForm = new JsonForm<TEntity>(entityList, count, page);
		return new Gson().toJson(jsonForm);
	}
	
	public static <TEntity extends Entity> String constructJsonForm(List<TEntity> entityList)
	{
		JsonForm<TEntity> jsonForm = new JsonForm<TEntity>(entityList);
		return new Gson().toJson(jsonForm);
	}
	
	public static <TEntity extends Entity> String constructJsonForm(TEntity entity)
	{
		JsonForm<TEntity> jsonForm = new JsonForm<TEntity>(entity);
		return new Gson().toJson(jsonForm);
	}
}