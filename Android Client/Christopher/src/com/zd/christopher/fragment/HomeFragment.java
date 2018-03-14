package com.zd.christopher.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zd.christopher.R;
import com.zd.christopher.activity.CourseResourceActivity;
import com.zd.christopher.adapter.CustomListAdapter;
import com.zd.christopher.bean.Course;
import com.zd.christopher.controller.AppController;
import com.zd.christopher.json.JsonResult;



public class HomeFragment extends Fragment
{
    // JSON地址
    private static final String url = "http://192.168.1.104:8181/Christopher/courseAction_findAll.action?form=";
    private ProgressDialog pDialog;
    //用来存储Movie对象的list
    private List<Course> courseList = new ArrayList<Course>();
    private ListView listView;
    private CustomListAdapter adapter;
    private ImageView imageView;
    
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
	    adapter = new CustomListAdapter(getActivity(), courseList);
	    
	    pDialog = new ProgressDialog(getActivity());
	    pDialog.setMessage("Loading...");
	    pDialog.show();

	        StringRequest movieReq = new StringRequest(url,
	        		                 new Response.Listener<String>() 
	        		                 {
	                    			 	public void onResponse(String response)
	                    			 	{
	                    			 		hidePDialog();
	                    			 		JsonResult<Course> jsonResult = null;
											try
											{
												jsonResult = new Gson().fromJson(new String(response.getBytes("ISO-8859-1"),"utf-8"), new TypeToken<JsonResult<Course>>(){}.getType());
											} 
											catch (Exception e)
											{
												e.printStackTrace();
											} 
	                    			 		System.out.println(jsonResult.getEntityList().get(0).getCourseName());
	                    			 		for(int i = 0; i < jsonResult.getEntityList().size(); i++)
	                    			 			courseList.add(jsonResult.getEntityList().get(i));                    			 	
	                    			 		adapter.notifyDataSetChanged(); 		
	                    			 		
	                    				    listView.post(new Runnable()
	                    				    {
	                    				        public void run()
	                    				        {
	                    				        	if(listView.getCount() == courseList.size())
	                    				        	{
	                    				        		imageView = (ImageView) getActivity().findViewById(R.id.favorite);
	                    				        		imageView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.like));
	                    				        	}
	                    				        }
	                    				    });
	                    			 	}		 	
									 },
	               					 new Response.ErrorListener() 
	               					 {
										 public void onErrorResponse(VolleyError error)
										 {
											 hidePDialog();
										 }
	               					 });
	        AppController.getInstance().addToRequestQueue(movieReq);
	}

	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.home_fragment, null);
		listView = (ListView) view.findViewById(R.id.list);
        listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				Course course = courseList.get(position);
				Bundle bundle = new Bundle();
				bundle.putSerializable("course", course);
				Intent intent = new Intent(getActivity(), CourseResourceActivity.class);
				intent.putExtras(bundle);
				getActivity().startActivity(intent);
			}
		});
	    listView.setAdapter(adapter);
	    return view;
	}

	public void onDestroy()
    {
        super.onDestroy();
        hidePDialog();
    }
 
    private void hidePDialog()
    {
        if (pDialog != null)
        {
            pDialog.dismiss();
            pDialog = null;
        }
    }
 
}
