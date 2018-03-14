package com.zd.christopher.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.reflect.TypeToken;
import com.zd.christopher.bean.Administrator;
import com.zd.christopher.bean.Faculty;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.transaction.AdministratorTransaction;
@Controller
@Scope("prototype")
public class AdministratorAction extends BaseAction<Administrator>
{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private AdministratorTransaction administratorTransaction;
	
	public AdministratorAction()
	{
		this.entityClass = Administrator.class;
	}

	public Boolean getModel()
	{
		super.getModel();
		jsonForm = gson.fromJson(form, new TypeToken<JsonForm<Administrator>>(){}.getType());
		return true;
	}
	

}
