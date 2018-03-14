package com.zd.christopher.adapter;
 
 
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.zd.christopher.R;
import com.zd.christopher.activity.CourseResourceActivity;
import com.zd.christopher.bean.Document;
import com.zd.christopher.controller.AppController;
 
public class DocumentListAdapter extends BaseAdapter 
{
    private Activity activity;
    private LayoutInflater inflater;
    private List<Document> documentItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
 
    public DocumentListAdapter(Activity activity, List<Document> documentItems) 
    {
        this.activity = activity;
        this.documentItems = documentItems;
    }
 
    @Override
    public int getCount()
    {
        return documentItems.size();
    }
 
    @Override
    public Object getItem(int location)
    {
        return documentItems.get(location);
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
        Document d = documentItems.get(position);
 
        // thumbnail image
        thumbNail.setImageUrl(d.getImage(), imageLoader);
         
        // title
        title.setText(d.getDocumentName());
         
        // rating
        rating.setText("上传人：" + d.getAuthor().getUserName());
         
        // genre    
        genre.setText("上传时间：" + d.getUpdatedTime().toString());
         
        // release year
        year.setText("");

        return convertView;
    }
 
}