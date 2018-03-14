package com.zd.christopher.action;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.reflect.TypeToken;
import com.zd.christopher.bean.User;
import com.zd.christopher.enumeration.Result;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.json.JsonResult;
import com.zd.christopher.transaction.UserTransaction;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> implements IUserAction
{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserTransaction userTransaction;
	
	public UserAction()
	{
		entityClass = User.class;
	}
	
	public Boolean getModel()
	{
		super.getModel();
		jsonForm = gson.fromJson(form, new TypeToken<JsonForm<User>>(){}.getType());
		return true;
	}
	
	public String login() throws UnsupportedEncodingException
	{
		if(userTransaction.login(jsonForm.getEntityList().get(0)))
		{	
			result = new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS).getBytes("UTF-8"));
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String updateFavorCourse()
	{
		return SUCCESS;
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
