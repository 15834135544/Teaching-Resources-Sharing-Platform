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

import com.zd.christopher.R;

public class WayFindingFragment extends Fragment
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
				flag = !flag;
				start.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.start));
				description.setEnabled(true);
				Toast.makeText(getActivity(), "解散公开课程成功！", Toast.LENGTH_SHORT).show();
			}
		});
		return v;
	}
	
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
   
	}
	
}
