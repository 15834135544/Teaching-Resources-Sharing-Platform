package com.zd.christopher.transaction;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Administrator;
import com.zd.christopher.dao.IAdministratorDAO;

@Service
public class AdministratorTransaction extends BaseTransaction<Administrator> implements IAdministratorTransaction
{
	@Resource
	private IAdministratorDAO administratorDAO;
	
	@PostConstruct
	public void init()
	{
		entityClass = Administrator.class;
	}

}
