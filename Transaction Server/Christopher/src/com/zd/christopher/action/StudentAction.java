package com.zd.christopher.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.reflect.TypeToken;
import com.zd.christopher.bean.Administrator;
import com.zd.christopher.bean.Student;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.transaction.StudentTransaction;
@Controller
@Scope("prototype")
public class StudentAction extends BaseAction<Student> implements IStudentAction
{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private StudentTransaction studentTransaction;
	
	public StudentAction()
	{
		this.entityClass = Student.class ;
	}
	
	public Boolean getModel()
	{
		super.getModel();
		jsonForm = gson.fromJson(form, new TypeToken<JsonForm<Student>>(){}.getType());
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
