package com.zd.christopher.action;

import java.io.UnsupportedEncodingException;

public interface IUserAction extends INaturalIdAction, INaturalNameAction
{
	public String login() throws UnsupportedEncodingException;
	public String updateFavorCourse();
}
