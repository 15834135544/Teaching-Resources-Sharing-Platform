package com.zd.christopher.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.zd.christopher.R;
import com.zd.christopher.adapter.VideoListAdapter;
import com.zd.christopher.bean.Course;
import com.zd.christopher.bean.Video;

public class VideoFragment extends Fragment
{
    private ProgressDialog pDialog;
    //用来存储Movie对象的list
    private List<Video> videoList = new ArrayList<Video>();
    private Course course;
    private ListView listView;
    private VideoListAdapter adapter;
    
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	 
	    Bundle bundle = getActivity().getIntent().getExtras();
	    course =  (Course) bundle.get("course");
	    for(Video video : course.getVideo())
	    	videoList.add(video);
	    adapter = new VideoListAdapter(getActivity(), videoList);
	    adapter.notifyDataSetChanged();
	}

	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.video_fragment, null);
		listView = (ListView) view.findViewById(R.id.video_list);
	    listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
			       Intent intent = new Intent(Intent.ACTION_VIEW);
			       Uri uri = Uri.parse(videoList.get(position).getUrl());
			       intent.setData (uri);
			       startActivity(intent);
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
