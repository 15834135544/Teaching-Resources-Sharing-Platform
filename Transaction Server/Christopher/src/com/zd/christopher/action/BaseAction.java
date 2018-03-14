package com.zd.christopher.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zd.christopher.bean.Entity;
import com.zd.christopher.enumeration.Result;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.json.JsonResult;
import com.zd.christopher.transaction.BaseTransaction;

public class BaseAction<TEntity extends Entity> extends ActionSupport implements ModelDriven<Boolean>, IBaseAction<TEntity>
{
	private static final long serialVersionUID = 1L;
	
	@Resource
	protected BaseTransaction<TEntity> baseTransaction;
	@Resource
	protected Gson gson;
	protected Class<TEntity> entityClass;
	
	protected String form;
	
	protected JsonForm<TEntity> jsonForm;
	protected InputStream result;

	public String getForm()
	{
		return form;
	}

	public void setForm(String form)
	{
		this.form = form;
	}	

	public InputStream getResult()
	{
		return result;
	}
	
	public void setResult(InputStream result)
	{
		this.result = result;
	}

	public JsonForm<TEntity> getJsonForm()
	{
		return jsonForm;
	}

	public Class<TEntity> getEntityClass()
	{
		return entityClass;
	}

	public void setEntityClass(Class<TEntity> entityClass)
	{
		this.entityClass = entityClass;
	}

	public Boolean getModel()
	{
		try
		{		
			result = new ByteArrayInputStream(JsonResult.constructResult(Result.FAILURE).getBytes("UTF-8"));
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public String add() throws UnsupportedEncodingException
	{
		baseTransaction.add(jsonForm.getEntityList().get(0));
		result = new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS).getBytes("UTF-8"));
		return SUCCESS;
	}

	public String delete() throws UnsupportedEncodingException
	{
		baseTransaction.delete(jsonForm.getEntityList().get(0));
		result = new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS).getBytes("UTF-8"));
		return SUCCESS;
	}

	public String update() throws UnsupportedEncodingException
	{
		baseTransaction.update(jsonForm.getEntityList().get(0));
		result = new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS).getBytes("UTF-8"));
		return SUCCESS;
	}
	
	public String find() throws UnsupportedEncodingException
	{
		baseTransaction.setEntityClass(getEntityClass());
		TEntity entity = baseTransaction.find(jsonForm.getEntityList().get(0));
		result = new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entity).getBytes("UTF-8"));
		return SUCCESS;
	}
	public String findAll() throws UnsupportedEncodingException
	{
		baseTransaction.setEntityClass(getEntityClass());
		List<TEntity> entityList = baseTransaction.findAll();
		result = new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entityList).getBytes("UTF-8"));
		return SUCCESS;
	}

	public String findByIds() throws UnsupportedEncodingException
	{
		baseTransaction.setEntityClass(getEntityClass());
		List<TEntity> entityList = baseTransaction.findByIds(jsonForm.getEntityList());
		result = new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entityList).getBytes("UTF-8"));
		return SUCCESS;
	}

	public String findByIdsByPage() throws UnsupportedEncodingException
	{
		baseTransaction.setEntityClass(getEntityClass());
		List<TEntity> entityList = baseTransaction.findByIdsByPage(jsonForm.getEntityList(), jsonForm.getCount(), jsonForm.getPage());
		result = new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entityList).getBytes("UTF-8"));
		return SUCCESS;
	}
}
