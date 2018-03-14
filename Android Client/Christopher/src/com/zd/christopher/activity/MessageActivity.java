package com.zd.christopher.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.zd.christopher.R;

public class MessageActivity extends Activity
{
	private ImageButton send_message;
	private ActionBar action_bar;
	private String url = "http://192.168.137.1:5555/VehicleManagementM/";
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_activity);
	
		
		setActionBar();
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.message, menu);
		
		send_message = (ImageButton) menu.findItem(R.id.send_message).getActionView();
		send_message.setImageDrawable(getResources().getDrawable(R.drawable.send_message));
		send_message.getBackground().setAlpha(0);
		send_message.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "提交成功",Toast.LENGTH_SHORT).show();
				finish();
			}
		});
		return true;
	}
	
    private void setActionBar()
    {
		action_bar = getActionBar();
		action_bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bar_bg));
		action_bar.setIcon(R.drawable.back);
		action_bar.setDisplayShowTitleEnabled(false);
		action_bar.setHomeButtonEnabled(true);
		action_bar.setDisplayShowHomeEnabled(true);
		action_bar.setDisplayHomeAsUpEnabled(false);
    }
    
    public boolean onOptionsItemSelected(MenuItem item) 
    {  
        if(item.getItemId() == android.R.id.home)
        	finish();

        return super.onOptionsItemSelected(item); 
    } 

}
