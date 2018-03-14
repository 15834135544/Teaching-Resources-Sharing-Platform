package com.zd.christopher.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zd.christopher.bean.Entity;
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
	
	public static <TEntity extends Entity> JsonResult<TEntity> constructResult(String jsonStr)
	{
		return new Gson().fromJson(jsonStr, new TypeToken<JsonResult<TEntity>>(){}.getType());
	}
}
