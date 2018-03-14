package com.zd.christopher.json;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.zd.christopher.bean.Entity;
import com.zd.christopher.bean.User;
import com.zd.christopher.enumeration.Result;

public class JsonResult<TEntity extends Entity>
{
	private Result result;
	private List<TEntity> entityList;
	
	private JsonResult(Result result, List<TEntity> entityList)
	{
		this.result = result;
		this.entityList = entityList;
	}
	
	private JsonResult(Result result, TEntity entity)
	{
		this.result = result;
		this.entityList = new ArrayList<TEntity>();
		this.entityList.add(entity);
	}
	
	private JsonResult(Result result)
	{
		this.result = result;
	}

	public Result getResult()
	{
		return result;
	}

	public void setResult(Result result)
	{
		this.result = result;
	}

	public List<TEntity> getEntityList()
	{
		return entityList;
	}

	public void setEntityList(List<TEntity> entityList)
	{
		this.entityList = entityList;
	}
	
	public static <TEntity extends Entity> String constructResult(Result result, List<TEntity> entityList)
	{
		List<TEntity> jsonEntityList = new ArrayList<TEntity>();
		for(TEntity entity : entityList)
			try
			{
				Method method = entity.getClass().getMethod("toJson", entity.getClass());
				TEntity jsonEntity = (TEntity) method.invoke(null, entity);
				jsonEntityList.add(jsonEntity);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		JsonResult<TEntity> jsonResult = new JsonResult<TEntity>(result, jsonEntityList);
		return new Gson().toJson(jsonResult);
	}
	
	public static <TEntity extends Entity> String constructResult(Result result, TEntity entity)
	{
		TEntity jsonEntity = null;
		try
		{
			Method method = entity.getClass().getMethod("toJson", entity.getClass());
			jsonEntity = (TEntity) method.invoke(null, entity);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		JsonResult<TEntity> jsonResult = new JsonResult<TEntity>(result, jsonEntity);
		return new Gson().toJson(jsonResult);
	}
	
	public static <TEntity extends Entity> String constructResult(Result result)
	{
		JsonResult<TEntity> jsonResult = new JsonResult<TEntity>(result);
		return new Gson().toJson(jsonResult);
	}
}
