package com.zd.christopher.transceiver;

import android.os.Handler;

import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class ActionRequest extends StringRequest
{
	Handler handler = new Handler();
	private final static Listener<String> LISTENER = new Response.Listener<String>()
	{
		public void onResponse(String response)
		{
			
		}
	};
	
	private final static ErrorListener ERROR_LISTENER =  new Response.ErrorListener()
	{
		public void onErrorResponse(VolleyError error)
		{
			
		}
	};

	public ActionRequest(String url)
	{
		//http:192.168.1.104:8181/Christopher/userAction_login.action?{......}
		super(url, ActionRequest.LISTENER, ActionRequest.ERROR_LISTENER);	
	}

}
