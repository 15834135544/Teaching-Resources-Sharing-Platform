package com.zd.christopher.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.reflect.TypeToken;
import com.zd.christopher.bean.Administrator;
import com.zd.christopher.bean.Video;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.transaction.VideoTransaction;
@Controller
@Scope("prototype")
public class VideoAction extends BaseAction<Video> implements IVideoAction
{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private VideoTransaction videoTransaction;
	
	public VideoAction()
	{
		this.entityClass = Video.class;
	}
	
	public Boolean getModel()
	{
		super.getModel();
		jsonForm = gson.fromJson(form, new TypeToken<JsonForm<Video>>(){}.getType());
		return true;
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
