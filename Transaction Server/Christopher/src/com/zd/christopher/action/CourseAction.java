package com.zd.christopher.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.reflect.TypeToken;
import com.zd.christopher.bean.Administrator;
import com.zd.christopher.bean.Course;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.transaction.CourseTransaction;
@Controller
@Scope("prototype")
public class CourseAction extends BaseAction<Course> implements ICourseAction
{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private CourseTransaction courseTransaction;
	
	public CourseAction()
	{
		this.entityClass = Course.class;
	}

	public Boolean getModel()
	{
		super.getModel();
		jsonForm = gson.fromJson(form, new TypeToken<JsonForm<Course>>(){}.getType());
		return true;
	}
	
	public String findByNaturalId()
	{
		return SUCCESS;
	}

	public String findByNaturalIds()
	{
		return SUCCESS;
	}

	public String findByNaturalIdsByPage()
	{
		return SUCCESS;
	}

	public String findByNaturalName()
	{
		return SUCCESS;
	}

	public String findByNaturalNameByPage()
	{
		return SUCCESS;
	}

	public String findByNaturalNames()
	{
		return SUCCESS;
	}

	public String findByNaturalNamesByPage()
	{
		return SUCCESS;
	}

}
