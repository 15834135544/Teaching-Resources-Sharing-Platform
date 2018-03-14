package com.zd.christopher.fragment;



import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.zd.christopher.R;

public class LocationMapFragment extends Fragment 
{
    private ImageButton start;
    private EditText description;
    private boolean flag = true;
    
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

	}
	
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) 
	{
		View v = inflater.inflate(R.layout.wayfinding_fragment, null);
		start = (ImageButton) v.findViewById(R.id.start);
		description = (EditText) v.findViewById(R.id.description);
		start.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				if(flag)
				{
					flag = !flag;
					start.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.close));
					description.setEnabled(false);
					Toast.makeText(getActivity(), "发布公开课信息成功！", Toast.LENGTH_SHORT).show();
				}
				else
				{
					flag = !flag;
					start.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.start));
					description.setEnabled(true);
					Toast.makeText(getActivity(), "解散公开课程成功！", Toast.LENGTH_SHORT).show();
				}
			}
		});
		return v;
	}
	
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

	}
}
