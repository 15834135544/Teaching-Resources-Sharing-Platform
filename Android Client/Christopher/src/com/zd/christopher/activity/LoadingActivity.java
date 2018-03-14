package com.zd.christopher.activity;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.zd.christopher.R;

public class LoadingActivity extends BaseActivity{

	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.loading);
		
		controller.register(this);
			
	new Handler().postDelayed(new Runnable()
	{
		public void run()
		{
			Intent intent = new Intent (LoadingActivity.this, MainActivity.class);			
			startActivity(intent);			
		}
	}, 200);
   }
}