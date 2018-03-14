package com.zd.christopher.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.christopher.bean.User;
import com.zd.christopher.dao.IUserDAO;

@Service
public class UserTransaction extends BaseTransaction<User> implements IUserTransaction
{
	@Resource
	private IUserDAO userDAO;
	
	@PostConstruct
	public void init()
	{
		entityClass = User.class;
	}

	public boolean login(User user)
	{
		User tempUser = userDAO.findByNaturalId(user.getUserId());
		if(tempUser == null)
			return false;
		if(user.getEncryptedPwd().equals(tempUser.getEncryptedPwd()))
			return true;
		return false;
	}
	
	public boolean updateFavorCourse(User user)
	{
		return false;
	}

	public User findByNaturalId(User entity)
	{
		return userDAO.findByNaturalId(entity.getUserId());
	}

	public List<User> findByNaturalIds(User[] entities)
	{
		List<String> idList = new ArrayList<String>();
		for(User user : entities)
			idList.add(user.getUserId());
		return userDAO.findByNaturalIds((String[]) idList.toArray());
	}

	public List<User> findByNaturalIdsByPage(User[] entities, Integer count, Integer page)
	{
		List<String> idList = new ArrayList<String>();
		for(User user : entities)
			idList.add(user.getUserId());
		return userDAO.findByNaturalIdsByPage((String[]) idList.toArray(), count, page);
	}

	public List<User> findByNaturalName(User entity)
	{
		return userDAO.findByNaturalName(entity.getUserName());
	}

	public List<User> findByNaturalNameByPage(User entity, Integer count, Integer page)
	{	
		return userDAO.findByNaturalNameByPage(entity.getUserName(), count, page);
	}

	public List<User> findByNaturalNames(User[] entities)
	{
		List<String> nameList = new ArrayList<String>();
		for(User user : entities)
			nameList.add(user.getUserName());
		return userDAO.findByNaturalNames((String[]) nameList.toArray());
	}
	
	public List<User> findByNaturalNamesByPage(User[] entities, Integer count, Integer page)
	{	
		List<String> nameList = new ArrayList<String>();
		for(User user : entities)
			nameList.add(user.getUserName());
		return userDAO.findByNaturalNamesByPage((String[]) nameList.toArray(), count, page);
	}
}
