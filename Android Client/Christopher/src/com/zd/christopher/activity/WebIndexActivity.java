package com.zd.christopher.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zd.christopher.R;

public class WebIndexActivity extends Activity
{
	private final static String web_index = "http://192.168.137.1:5555/VehicleManagement";
	
	private WebView web_view;
	private WebSettings web_settings;
	private ActionBar action_bar;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_index);
		
		setActionBar();

		setWebView();
		
		new Thread(new Runnable()
		{
			public void run()
			{
				try
				{
					web_view.loadUrl(web_index);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}
    
    @SuppressWarnings("deprecation")
	private void setWebView()
    {
    	web_view = (WebView) findViewById(R.id.web_index);
    	
    	web_settings = web_view.getSettings();
    	web_view.setWebViewClient(new WebViewClient());
    	web_settings.setJavaScriptEnabled(true);
		web_view.setWebChromeClient(new WebChromeClient() {}); 
//		web_settings.setPluginsEnabled(true);
		web_settings.setPluginState(PluginState.ON); 
		web_view.setVisibility(View.VISIBLE);
//		mwebSettings.setUseWideViewPort(true);
		web_settings.setAllowFileAccess(true);
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
