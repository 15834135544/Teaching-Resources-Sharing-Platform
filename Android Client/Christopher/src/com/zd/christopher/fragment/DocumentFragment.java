package com.zd.christopher.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.DownloadManager;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.zd.christopher.R;
import com.zd.christopher.adapter.DocumentListAdapter;
import com.zd.christopher.bean.Course;
import com.zd.christopher.bean.Document;

public class DocumentFragment extends Fragment
{
    private ProgressDialog pDialog;
    //用来存储Movie对象的list
    private List<Document> documentList = new ArrayList<Document>();
    private Course course;
    private ListView listView;
    private DocumentListAdapter adapter;
    private ImageView imageView;
    
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	 
	    Bundle bundle = getActivity().getIntent().getExtras();
	    course =  (Course) bundle.get("course");
	    for(Document document : course.getDocument())
	    	documentList.add(document);
	    adapter = new DocumentListAdapter(getActivity(), documentList);
	    adapter.notifyDataSetChanged();
	}

	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.document_fragment, null);
		listView = (ListView) view.findViewById(R.id.document_list);
	    listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				Toast.makeText(getActivity().getApplicationContext(), "文件开始下载!", Toast.LENGTH_SHORT).show();
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse("http://192.168.1.104:8181/Christopher/document/" + documentList.get(position).getId() + documentList.get(position).getType()));
				//指定下载路径和下载文件名
				request.setDestinationInExternalPublicDir("/download/", documentList.get(position).getDocumentName());
				//获取下载管理器
				DownloadManager downloadManager= (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
				//将下载任务加入下载队列，否则不会进行下载
				downloadManager.enqueue(request);
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
