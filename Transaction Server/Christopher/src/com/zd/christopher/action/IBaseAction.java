package com.zd.christopher.action;

import java.io.UnsupportedEncodingException;

import com.zd.christopher.bean.Entity;

public interface IBaseAction<TEntity extends Entity>
{
	public String add() throws UnsupportedEncodingException;
	public String update() throws UnsupportedEncodingException;
	public String delete() throws UnsupportedEncodingException;
	public String find() throws UnsupportedEncodingException;
	public String findByIds() throws UnsupportedEncodingException;
	public String findByIdsByPage() throws UnsupportedEncodingException;
}
