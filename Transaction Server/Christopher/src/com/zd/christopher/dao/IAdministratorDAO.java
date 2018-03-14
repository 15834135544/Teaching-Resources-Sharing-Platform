package com.zd.christopher.dao;

import com.zd.christopher.bean.Administrator;

public interface IAdministratorDAO extends IEntityDAO<Administrator>
{
	public boolean updateCourse(Administrator administrator);
}
