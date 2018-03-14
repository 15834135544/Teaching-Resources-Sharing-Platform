package com.zd.christopher.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.zd.christopher.R;

public class MainMapFragment extends Fragment
{
	private BaiDuMapFragment baidu_map_fragment;
	private LocationMapFragment location_map_fragment;
	private RadioGroup map_radio_group;
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) 
	{
		return inflater.inflate(R.layout.main_map_fragment, null);
	}
	
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		initView();
	}

	public void initView()
	{
		baidu_map_fragment = new BaiDuMapFragment();
		getFragmentManager().beginTransaction().replace(R.id.map_content, baidu_map_fragment)
			.commit();	
		
		map_radio_group = (RadioGroup) getView().findViewById(R.id.map_radio_group);
		map_radio_group.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				switch (checkedId)
				{
					case R.id.map_rb_baidu_map:
						baidu_map_fragment = new BaiDuMapFragment();
						getFragmentManager().beginTransaction().replace(R.id.map_content, baidu_map_fragment)
							.commit();
						break;
						
					case R.id.map_rb_location_map:
						location_map_fragment = new LocationMapFragment();
						getFragmentManager().beginTransaction().replace(R.id.map_content, location_map_fragment).commit();
						break;
					default:
						break;
				}
			}
		});
		
	}
}
