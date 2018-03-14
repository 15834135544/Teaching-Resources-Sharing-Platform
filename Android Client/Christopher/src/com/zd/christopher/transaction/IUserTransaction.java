package com.zd.christopher.transaction;

import com.zd.christopher.bean.User;

public interface IUserTransaction extends INaturalIdTransaction<User>, INaturalNameTransaction<User>
{
	public boolean login(User user);
	public boolean updateFavorCourse(User user);
}
