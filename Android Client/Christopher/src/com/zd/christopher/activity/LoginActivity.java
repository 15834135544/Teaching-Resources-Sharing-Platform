package com.zd.christopher.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zd.christopher.R;
import com.zd.christopher.bean.User;
import com.zd.christopher.database.DataBase;
import com.zd.christopher.enumeration.Result;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.json.JsonResult;

public class LoginActivity extends BaseActivity
{
	private EditText mUser;
	private EditText mPassword; 

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        mUser = (EditText)findViewById(R.id.login_user_edit);
        mPassword = (EditText)findViewById(R.id.login_passwd_edit);
        
        controller.register(this);
        
        getActionBar().hide();
    }

    public void login_mainweixin(View v)
    {
    	User user = new User(mUser.getText().toString(), mPassword.getText().toString());
    	String jsonForm = "";
    	try
    	{
    		jsonForm = JsonForm.constructJsonForm(user);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	StringRequest stringRequest = new StringRequest(
    								  "http://192.168.1.104:8181/Christopher/userAction_login.action?form=" + jsonForm,  
    								  new Response.Listener<String>() 
    								  {  
    									  public void onResponse(String response) 
    									  {  
    										  
    										  JsonResult<User> jsonResult = null;
    										  try
    										  {
    											  jsonResult = JsonResult.constructResult(response);
    											  if(Result.SUCCESS == jsonResult.getResult())
        										  {
    												  DataBase.insertUser(getApplicationContext(), mUser.getText().toString());
        											  Intent intent = new Intent(LoginActivity.this, LoadingActivity.class);
        											  startActivity(intent);
        										  }
    											  else
    												  Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
    										  }
    										  catch(Exception e)
    										  {
    											  e.printStackTrace();
    										  }
    										  
    									  }  
    								  }, 
    								  new Response.ErrorListener() 
    								  {  
    									  public void onErrorResponse(VolleyError error)
    									  {  
    										  Toast.makeText(getApplicationContext(), "连接服务器失败", Toast.LENGTH_SHORT).show();
    									  }  
    								  });  
    	mQueue.add(stringRequest);
    }  
}
