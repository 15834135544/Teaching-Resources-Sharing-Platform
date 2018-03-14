package com.zd.christopher.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.zd.christopher.R;
import com.zd.christopher.bean.Course;
import com.zd.christopher.bean.RoleInfo;
import com.zd.christopher.bean.User;
import com.zd.christopher.controller.AppController;

public class StreamListAdapter extends BaseAdapter
{
	   private Activity activity;
	   private LayoutInflater inflater;
	   private List<RoleInfo> roleItems;
	   private List<User> userItems;
	   ImageLoader imageLoader = AppController.getInstance().getImageLoader();
	 
	    public StreamListAdapter(Activity activity, List<RoleInfo> roleItems, List<User> userItems) 
	    {
	        this.activity = activity;
	        this.roleItems = roleItems;
	        this.userItems = userItems;
	    }
	 
	    @Override
	    public int getCount()
	    {
	        return roleItems.size();
	    }
	 
	    @Override
	    public Object getItem(int location)
	    {
	        return roleItems.get(location);
	    }
	 
	    @Override
	    public long getItemId(int position)
	    {
	        return position;
	    }
	 
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent)
	    {
	 
	        if (inflater == null)
	            inflater = (LayoutInflater) activity
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        if (convertView == null)
	            convertView = inflater.inflate(R.layout.list_row, null);
	 
	        if (imageLoader == null)
	            imageLoader = AppController.getInstance().getImageLoader();
	        NetworkImageView thumbNail = (NetworkImageView) convertView
	                .findViewById(R.id.thumbnail);
	        TextView title = (TextView) convertView.findViewById(R.id.title);
	        TextView rating = (TextView) convertView.findViewById(R.id.rating);
	        TextView genre = (TextView) convertView.findViewById(R.id.genre);
	        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);
	 
	        // getting movie data for the row
	        RoleInfo r = roleItems.get(position);
	 
	        // thumbnail image
	        thumbNail.setImageUrl("http://192.168.1.104:8181/Christopher/pic/streampic/stream.jpg", imageLoader);
	         
	        // title
	        title.setText(String.valueOf(r.getName()));
	         
	        // rating
	        rating.setText("");
	         
	        // genre    
	        genre.setText("");
	         
	        // release year
	        year.setText("");
	        
	 
	        return convertView;
	    }
}
