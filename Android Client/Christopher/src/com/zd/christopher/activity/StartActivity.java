package com.zd.christopher.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.zd.christopher.R;

public class StartActivity extends BaseActivity
{

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		getActionBar().hide();
		
		controller.register(this);
		
		new Handler().postDelayed(new Runnable()
		{
			public void run()
			{
				Intent intent = new Intent(StartActivity.this, WelcomeActivity.class);			
				startActivity(intent);			
				finish();
			}
		}, 1000);
	}
}
