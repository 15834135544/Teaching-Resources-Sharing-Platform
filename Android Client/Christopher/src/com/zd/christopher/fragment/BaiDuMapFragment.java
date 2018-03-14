package com.zd.christopher.fragment;



import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.BaiduMapNavigation;
import com.baidu.mapapi.navi.NaviParaOption;
import com.zd.christopher.R;

public class BaiDuMapFragment extends Fragment 
{
    private MapStatus map_status;
    private LatLng center;
    private  MapStatusUpdate status_update;
    private MapView map_view;
    private BaiduMap baidu_map;
    boolean isFirstLoc = true; // 是否首次定位
    
    private LocationClient mLocClient;
    private NaviParaOption navi_opt;
    public MyLocationListenner myListener = new MyLocationListenner();
    
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

	}
	
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) 
	{
		return inflater.inflate(R.layout.map_fragment, null);
	}
	
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		map_view = (MapView) getView().findViewById(R.id.map_view);
		baidu_map = map_view.getMap();
		
		center = new LatLng(43.816793, 125.418176);
		map_status = new MapStatus.Builder().target(center).overlook(0).zoom(17).build();
	    status_update = MapStatusUpdateFactory.newMapStatus(map_status);
	    baidu_map.setMapStatus(status_update); 
	    
		navi_opt = new NaviParaOption();
//		navi_opt.endPoint(new LatLng(43.816793, 125.418176));
		navi_opt.endName("end");
		navi_opt.startName("start");
		
	    mLocClient = new LocationClient(getActivity());
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        mLocClient.start();      
  
	    Bitmap oldBitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.icon_marka);
	    Bitmap resizeBmp = ThumbnailUtils.extractThumbnail(oldBitmap, 50, 50);  
	    BitmapDescriptor bitmap = BitmapDescriptorFactory.fromBitmap(resizeBmp);
	    
	    
	    final LatLng point = new LatLng(43.817151, 125.421557);  
	    Button button = new Button(this.getActivity());
	    button.setText("公开课信息\n教师：邓蕾蕾\n课程：计算机组成原理实践\n(点击以开启自动寻路)");
	    button.setTextSize(10.0f);
	    button.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				navi_opt.endPoint(new LatLng(43.816793, 125.418176));
				BaiduMapNavigation.openWebBaiduMapNavi(navi_opt, getActivity());
			}
		});
	    final InfoWindow infoWindow = new InfoWindow(button, point, -47); 
	    OverlayOptions option1 = new MarkerOptions()  
	        .position(point)  
	        .icon(bitmap);  
	    baidu_map.addOverlay(option1);
	    
	    final LatLng point2 = new LatLng(43.817321, 125.413939); 
	    OverlayOptions option2 = new MarkerOptions()  
        .position(point2)  
        .icon(bitmap);  
	    baidu_map.addOverlay(option2);
	    final LatLng point3 = new LatLng(43.821441, 125.416791);
	    OverlayOptions option3 = new MarkerOptions()  
        .position(point3)  
        .icon(bitmap);  
	    baidu_map.addOverlay(option3);
	    final LatLng point4 = new LatLng(43.819737, 125.421723);
	    OverlayOptions option4 = new MarkerOptions()  
        .position(point4)  
        .icon(bitmap);  
	    baidu_map.addOverlay(option4);
	    final LatLng point5 = new LatLng(43.816381, 125.419531);
	    OverlayOptions option5 = new MarkerOptions()  
        .position(point5)  
        .icon(bitmap);  
	    baidu_map.addOverlay(option5);
	    final LatLng point6 = new LatLng(43.817805, 125.41786);
	    OverlayOptions option6 = new MarkerOptions()  
        .position(point6)  
        .icon(bitmap);  
	    baidu_map.addOverlay(option6);
	    final LatLng point7 = new LatLng(43.814748, 125.419244);
	    OverlayOptions option7 = new MarkerOptions()  
        .position(point7)  
        .icon(bitmap);  
	    baidu_map.addOverlay(option7);
	    
	    
	    baidu_map.setOnMarkerClickListener(new OnMarkerClickListener()
		{	
			public boolean onMarkerClick(Marker marker)
			{
				if(marker.getPosition().toString().equals(point.toString()))
				{
					baidu_map.showInfoWindow(infoWindow);
				}
				return false;
			}
		});
	}
	
	public class MyLocationListenner implements BDLocationListener 
	{
		public void onReceiveLocation(BDLocation location)
		{
			navi_opt.startPoint(new LatLng(location.getLatitude(), location.getLongitude()));
		}

		public void onReceivePoi(BDLocation poiLocation) 
		{
	        	
		}
	}

	public void onPause() 
	{
		mLocClient.stop();
		super.onPause();
	}

	public void onResume()
	{
		super.onResume();
	}

	public void onDestroy() 
	{
		
		super.onDestroy();
	}
}
