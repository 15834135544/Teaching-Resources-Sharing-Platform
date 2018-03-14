package com.zd.christopher.transaction;

import com.zd.christopher.bean.Administrator;

public class AdministratorTransaction extends BaseTransaction<Administrator> implements IAdministratorTransaction
{
	public AdministratorTransaction()
	{
		entityClass = Administrator.class;
	}

}
