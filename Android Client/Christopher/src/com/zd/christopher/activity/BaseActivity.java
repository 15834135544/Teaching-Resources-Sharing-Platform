package com.zd.christopher.activity;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.zd.christopher.R;
import com.zd.christopher.controller.ActivityController;

public abstract class BaseActivity extends Activity implements IBaseActivity
{
	protected static final ActivityController controller = ActivityController.getInstance();
	protected static boolean exitAppFlag = false;
	protected RequestQueue mQueue;
	protected static final Handler exitAppHandler = new Handler()
	{
		public void handleMessage(Message msg) 
		{
			super.handleMessage(msg);
			exitAppFlag = false;
		}
	};

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		controller.register(this);
		mQueue = Volley.newRequestQueue(this);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
        if (keyCode == KeyEvent.KEYCODE_BACK) 
        	return exitApp();
        return super.onKeyDown(keyCode, event);
	}

	public boolean exitApp()
	{
        if (!exitAppFlag) 
        {
        	exitAppFlag = true;
            Toast.makeText(getApplicationContext(), getString(R.string.exit_app), Toast.LENGTH_SHORT).show();
            exitAppHandler.sendEmptyMessageDelayed(0, 2000);
        }
        else 
        	if(controller.exitApp())
    			return true;
    	return false;
	}
}
