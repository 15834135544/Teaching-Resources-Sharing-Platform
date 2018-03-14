package com.zd.christopher.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zd.christopher.bean.Course;
import com.zd.christopher.bean.Faculty;
import com.zd.christopher.bean.User;
import com.zd.christopher.enumeration.Result;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.reflector.Reflector;

public class UnitTest
{
	
	@Test
	public void testGson()
	{
		Gson gson = new Gson();
		User user[] = new User[2];
		user[0] = new User("1");
		user[1] = new User("2");
		String str = gson.toJson(user);
		System.out.println(str);
		User user2[] = gson.fromJson(str, User[].class);
		System.out.println(new Gson().toJson(user2[0]));
	}
	
	@Test
	public void testUserGson()
	{
		Result r = Result.SUCCESS;
		String str = new Gson().toJson(r);
		System.out.println(str);
		Result r1 = new Gson().fromJson(str, Result.class);
		System.out.println(r1.getString());
	}
	
	@Test
	public void testUserGsonObject()
	{
		User user = new User("18");
		String str = new Gson().toJson(user);
		User user2[] = new Gson().fromJson(str, User[].class);
		System.out.println(user2[0].getUserId());
	}
	
	@Test
	public void testSingleton()
	{
		User user = new User("111", "222");
		System.out.println(user.getEncryptedPwd());
	}
	
	@Test
	public void testCombinator()
	{
		User user1 = new User("111");
		User user2 = new User();
		user2.setPwd("12345");
		Reflector.mergePOJOs(user2, user1);
		System.out.println(user1.getPwd());
		System.out.println(user1.getEncryptedPwd());
	}
	
	@Test
	public void testUpdate()
	{
		User user = new User();
		user.setId(1);
		user.setPwd("941005");
		user.setAddress("ChangChun");
		System.out.println(new Gson().toJson(user));
	}
	
	@Test
	public void testCascadeUpdate()
	{
		User user = new User();
		user.setId(1);
//		Set<Course> favorCourse = new HashSet<Course>();
//		Course course = new Course();
//		course.setId(1);
//		favorCourse.add(course);
//		user.setFavorCourse(favorCourse);
		System.out.println(new Gson().toJson(user));
	}
	
	@Test
	public void testBase()
	{
		JsonForm<User> jsonForm = new JsonForm<User>();
		List<User> userList = new ArrayList<User>();
		User user = new User("478808117", "941005");
		userList.add(user);
		jsonForm.setEntityList(userList);
		String str = new Gson().toJson(jsonForm);
		System.out.println(str);
		JsonForm<User> jsonForm2 = new Gson().fromJson(str, new TypeToken<JsonForm<User>>(){}.getType());
		System.out.println(jsonForm2.getEntityList().size());
		System.out.println(jsonForm2.getEntityList().get(0).getUserId());
	}
	
	@Test
	public void testNEW()
	{
		User user = new User();
		user.setId(1);
		user.setUserId("478808117@qq.com");
		user.setAddress("JL.CC");
		JsonForm jsonForm = new JsonForm();
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		jsonForm.setEntityList(userList);
		System.out.println(new Gson().toJson(jsonForm));
	}
	
	@Test
	public void testJSON()
	{
		User user = new User();
		user.setUserName("张达");
		System.out.println(JsonForm.constructJsonForm(user));
	}
	
	@Test
	public void testCourse()
	{
		Course course = new Course();
		course.setCourseId("jlu001");
		System.out.println(JsonForm.constructJsonForm(course));
	}
	
	@Test
	public void testFaculty()
	{
		User user = new User("478808117@qq.com", "123456");
		System.out.println(new Gson().toJson(user));
	}
}
