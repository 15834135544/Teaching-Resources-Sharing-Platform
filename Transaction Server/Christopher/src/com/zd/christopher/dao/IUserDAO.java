package com.zd.christopher.dao;

import com.zd.christopher.bean.User;

public interface IUserDAO extends IEntityDAO<User>, INaturalIdDAO<User>, INaturalNameDAO<User>
{
	public boolean updateFavorCourse(User user);
}
