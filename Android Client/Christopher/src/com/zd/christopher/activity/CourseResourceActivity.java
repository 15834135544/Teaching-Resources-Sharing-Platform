package com.zd.christopher.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.baidu.mapapi.SDKInitializer;
import com.zd.christopher.R;
import com.zd.christopher.fragment.DocumentFragment;
import com.zd.christopher.fragment.QuizFragment;
import com.zd.christopher.fragment.VideoFragment;

public class CourseResourceActivity extends Activity
{
	private DocumentFragment documentFragment;
	private VideoFragment videoFragment;
	private QuizFragment quizFragment;
	private RadioGroup courseResourceGroup;
	private ActionBar actionBar;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());  
		setContentView(R.layout.course_resource_activity);	
		setActionBar();
		initView();
	}

	public void initView()
	{
		documentFragment = new DocumentFragment();
		getFragmentManager().beginTransaction().replace(R.id.course_resource_content, documentFragment)
			.commit();
		courseResourceGroup = (RadioGroup) findViewById(R.id.course_resource_group);
		courseResourceGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
		{
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				switch (checkedId)
				{
					case R.id.document_radio_button:
						documentFragment = new DocumentFragment();
						getFragmentManager().beginTransaction().replace(R.id.course_resource_content, documentFragment)
							.commit();
						break;
					case R.id.video_radio_button:
							videoFragment = new VideoFragment();
						getFragmentManager().beginTransaction().replace(R.id.course_resource_content, videoFragment)
							.commit();
						break;
					case R.id.quiz_radio_button:
						quizFragment = new QuizFragment();
					getFragmentManager().beginTransaction().replace(R.id.course_resource_content, quizFragment)
						.commit();
					break;
					default:
						break;
				}
			}
		});
	}
	
    private void setActionBar()
    {
    	actionBar = getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);  
		actionBar.setCustomView(R.layout.course_resource_action_bar);
    	actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bar_bg));
		actionBar.setIcon(R.drawable.back);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(false);
    }
	
    public boolean onOptionsItemSelected(MenuItem item) 
    {  
        if(item.getItemId() == android.R.id.home)
        	finish();

        return super.onOptionsItemSelected(item); 
    } 
}
