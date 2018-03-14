package com.zd.christopher.adapter;
 
 
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.zd.christopher.R;
import com.zd.christopher.bean.Course;
import com.zd.christopher.controller.AppController;
 
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Course> courseItems;
//    private List<ImageView> imageViewList = new ArrayList<ImageView>();
//    private ImageView imageView;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
 
    public CustomListAdapter(Activity activity, List<Course> courseItems) 
    {
        this.activity = activity;
        this.courseItems = courseItems;
    }
 
    @Override
    public int getCount()
    {
        return courseItems.size();
    }
 
    @Override
    public Object getItem(int location)
    {
        return courseItems.get(location);
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
        
//        imageViewList.add((ImageView) convertView.findViewById(R.id.favorite));
//        for(int i = 0; i < imageViewList.size(); i++)
//        {
//        	imageView = imageViewList.get(i);
//        	imageView.
//        	imageView.setOnClickListener(new View.OnClickListener()
//			{
//				public void onClick(View v)
//				{
//					imageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.like));
//				}
//			});
//        }
	 
        // getting movie data for the row
        Course c = courseItems.get(position);
 
        // thumbnail image
        thumbNail.setImageUrl(c.getFaculty().getImage(), imageLoader);
         
        // title
        title.setText(c.getCourseName());
         
        // rating
        rating.setText(String.valueOf(c.getIntroduction()));
         
        // genre    
        genre.setText(c.getFaculty().getFacultyName());
         
        // release year
        year.setText(c.getSemester());
        
 
        return convertView;
    }
 
}