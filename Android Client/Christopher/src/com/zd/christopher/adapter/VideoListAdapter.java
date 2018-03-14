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
import com.zd.christopher.bean.Video;
import com.zd.christopher.controller.AppController;
 
public class VideoListAdapter extends BaseAdapter 
{
    private Activity activity;
    private LayoutInflater inflater;
    private List<Video> videoItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
 
    public VideoListAdapter(Activity activity, List<Video> videoItems) 
    {
        this.activity = activity;
        this.videoItems = videoItems;
    }
 
    @Override
    public int getCount()
    {
        return videoItems.size();
    }
 
    @Override
    public Object getItem(int location)
    {
        return videoItems.get(location);
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
        Video v = videoItems.get(position);
 
        // thumbnail image
        thumbNail.setImageUrl(v.getImage(), imageLoader);
         
        // title
        title.setText(v.getVideoName());
         
        // rating
        rating.setText("上传人：" + v.getAuthor().getUserName());
         
        // genre    
        genre.setText("上传时间：" + v.getUpdatedTime().toString());
         
        // release year
        year.setText("");

        return convertView;
    }
 
}