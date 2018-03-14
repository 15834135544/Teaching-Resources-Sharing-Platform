package com.zd.christopher.bean;

public class RoleInfo extends Entity {
	private String mStrName;
	private String mStrUserID;
	private int mRoleIconID;

	public void setName(String strName) {
		mStrName = strName;
	}

	public String getName() {
		return mStrName;
	}

	public void setUserID(String strUserID) {
		mStrUserID = strUserID;
	}

	public String getUserID() {
		return mStrUserID;
	}
	
	public void setRoleIconID(int iconID) {
		mRoleIconID = iconID;
	}

	public int getRoleIconID() {
		return mRoleIconID;
	}

	public String findPath()
	{
		return null;
	}
}
