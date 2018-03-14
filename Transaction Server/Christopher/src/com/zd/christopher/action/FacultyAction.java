package com.zd.christopher.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.reflect.TypeToken;
import com.zd.christopher.bean.Administrator;
import com.zd.christopher.bean.Faculty;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.transaction.FacultyTransaction;

@Controller
@Scope("prototype")
public class FacultyAction extends BaseAction<Faculty> implements IFacultyAction
{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private FacultyTransaction facultyTransaction;
	
	public FacultyAction()
	{
		this.entityClass = Faculty.class;
	}
	
	public Boolean getModel()
	{
		super.getModel();
		jsonForm = gson.fromJson(form, new TypeToken<JsonForm<Faculty>>(){}.getType());
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

	@Override
	public String findByNaturalNamesByPage()
	{
		
		return SUCCESS;
	}

}
