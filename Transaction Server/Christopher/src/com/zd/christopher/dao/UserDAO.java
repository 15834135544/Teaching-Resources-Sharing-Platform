package com.zd.christopher.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.User;

@Repository
public class UserDAO extends EntityDAO<User> implements IUserDAO
{
	@PostConstruct
	public void init()
	{
		entityClass = User.class;
	}

	public User findByNaturalId(String id)
	{
		return null;
	}
	
	public List<User> findByNaturalIds(String[] ids)
	{	
		return null;
	}
	
	public List<User> findByNaturalIdsByPage(String[] ids, Integer count, Integer page)
	{	
		return null;
	}
	
	public List<User> findByNaturalName(String name)
	{
		return null;
	}
	
	public List<User> findByNaturalNames(String[] name)
	{
		return null;
	}

	public List<User> findByNaturalNameByPage(String name, Integer count, Integer page)
	{	
		return null;
	}

	public List<User> findByNaturalNamesByPage(String[] name, Integer count, Integer page)
	{
		return null;
	}

	public boolean updateFavorCourse(User user)
	{
		return false;
	}

}
