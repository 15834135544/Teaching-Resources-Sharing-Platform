package com.zd.christopher.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.bairuitech.anychat.AnyChatCoreSDK;
import com.zd.christopher.R;
import com.zd.christopher.activity.MainActivity;
import com.zd.christopher.activity.SpectatorActivity;
import com.zd.christopher.activity.VideoActivity;
import com.zd.christopher.adapter.StreamListAdapter;
import com.zd.christopher.bean.RoleInfo;
import com.zd.christopher.bean.User;
import com.zd.christopher.database.DataBase;

public class ParkingFragment extends Fragment 
{
    private List<RoleInfo> roleList = new ArrayList<RoleInfo>();
    private List<User> userList = new ArrayList<User>();
    private ListView listView;
    private StreamListAdapter adapter;
    private AnyChatCoreSDK anyChatCoreSDK;
    private int[] ids;
    
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		adapter = new StreamListAdapter(getActivity(), roleList, userList);
		anyChatCoreSDK = MainActivity.anyChatSDK;
		
		ids = anyChatCoreSDK.GetRoomOnlineUsers(8181);
		System.out.println("当前房间内人数（不算自己）：" + ids.length);
		for(Integer id : ids)
		{
			System.out.println(id);
//			if(id > 0)
//			{
				RoleInfo roleInfo = new RoleInfo();
				roleInfo.setUserID(id.toString());
				roleInfo.setName(anyChatCoreSDK.GetUserName(id));
				roleList.add(roleInfo);
//			}
		}
	    adapter.notifyDataSetChanged();   
	}

	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.parking_fragment, null);
		Button button = (Button) view.findViewById(R.id.start);
		button.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent(getActivity(), VideoActivity.class);
				if(ids.length == 0)
					intent.putExtra("UserID", "-1");
				else
				{
					intent.putExtra("UserID", String.valueOf(ids[0]));
					System.out.println("看直播的对象是：" + anyChatCoreSDK.GetUserName(ids[0]));
				}
				startActivity(intent);
			}
		});
		listView = (ListView) view.findViewById(R.id.stream_list);
        listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				Intent intent = new Intent(getActivity(), SpectatorActivity.class);
				intent.putExtra("UserID", String.valueOf(ids[position]));
				startActivity(intent);
			}
		});
	    listView.setAdapter(adapter);
	    return view;
	}
}
