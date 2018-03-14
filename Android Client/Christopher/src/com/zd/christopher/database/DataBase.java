package com.zd.christopher.database;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class DataBase
{
	public static void insertUser(Context context, String id)
	{
		SharedPreferences database = context.getSharedPreferences("user", Activity.MODE_PRIVATE);
		database.edit().putString("userId", id).commit();
	}
	
	public static void insertUserName(Context context, String userName)
	{
		SharedPreferences database = context.getSharedPreferences("userName", Activity.MODE_PRIVATE);
		database.edit().putString("userName", userName).commit();
	}
	
	public static void insertId(Context context, Integer id)
	{
		SharedPreferences database = context.getSharedPreferences("id", Activity.MODE_PRIVATE);
		database.edit().putInt("id", id).commit();
	}
	
	public static void deleteUser(Context context)
	{
		SharedPreferences database = context.getSharedPreferences("user", Activity.MODE_PRIVATE);
		database.edit().clear().commit();
	}
	
	public static void deleteUserName(Context context)
	{
		SharedPreferences database = context.getSharedPreferences("userName", Activity.MODE_PRIVATE);
		database.edit().clear().commit();
	}
	
	public static void deleteId(Context context)
	{
		SharedPreferences database = context.getSharedPreferences("id", Activity.MODE_PRIVATE);
		database.edit().clear().commit();
	}
	
	public static String getUser(Context context)
	{
		SharedPreferences database = context.getSharedPreferences("user", Activity.MODE_PRIVATE);
		return database.getString("userId", "");
	}
	
	public static String getUserName(Context context)
	{
		SharedPreferences database = context.getSharedPreferences("userName", Activity.MODE_PRIVATE);
		return database.getString("userName", "");
	}
	
	public static Integer getId(Context context)
	{
		SharedPreferences database = context.getSharedPreferences("id", Activity.MODE_PRIVATE);
		return database.getInt("id", 0);
	}
	
	public static void insertAvatar(Context context, String id, String path)
	{
		SharedPreferences database = context.getSharedPreferences("avatar", Activity.MODE_PRIVATE);
		database.edit().putString(id, path).commit();
	}
	
	public static String getAvatar(Context context, String id)
	{
		SharedPreferences database = context.getSharedPreferences("avatar", Activity.MODE_PRIVATE);
		return database.getString(id, "");
	}
}