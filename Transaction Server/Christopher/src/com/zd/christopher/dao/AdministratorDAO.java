package com.zd.christopher.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.zd.christopher.bean.Administrator;

@Repository
public class AdministratorDAO extends EntityDAO<Administrator> implements IAdministratorDAO
{
	@PostConstruct
	public void init()
	{
		entityClass = Administrator.class;
	}

	public boolean updateCourse(Administrator administrator)
	{
		return false;
	}
}
