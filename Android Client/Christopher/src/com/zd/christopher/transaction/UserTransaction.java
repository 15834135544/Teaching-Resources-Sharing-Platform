package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.User;

public class UserTransaction extends BaseTransaction<User> implements IUserTransaction
{
	private static final String URL = BaseTransaction.URL + "userAction_";
	
	public UserTransaction()
	{
		entityClass = User.class;
	}

	public boolean login(User user)
	{
		return false;
	}
	
	public boolean updateFavorCourse(User user)
	{
		return false;
	}

	public User findByNaturalId(User entity)
	{
		return null;
	}

	public List<User> findByNaturalIds(User[] entities)
	{
		return null;
	}

	public List<User> findByNaturalIdsByPage(User[] entities, Integer count, Integer page)
	{
		return null;
	}

	public List<User> findByNaturalName(User entity)
	{
		return null;
	}

	public List<User> findByNaturalNameByPage(User entity, Integer count, Integer page)
	{	
		return null;
	}

	public List<User> findByNaturalNames(User[] entities)
	{
		return null;
	}
	
	public List<User> findByNaturalNamesByPage(User[] entities, Integer count, Integer page)
	{	
		return null;
	}
}
