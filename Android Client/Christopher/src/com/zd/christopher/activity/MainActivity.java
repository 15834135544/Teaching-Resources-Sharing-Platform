package com.zd.christopher.activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baidu.mapapi.SDKInitializer;
import com.bairuitech.anychat.AnyChatBaseEvent;
import com.bairuitech.anychat.AnyChatCoreSDK;
import com.bairuitech.anychat.AnyChatDefine;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zd.christopher.R;
import com.zd.christopher.bean.User;
import com.zd.christopher.controller.ActivityController;
import com.zd.christopher.database.DataBase;
import com.zd.christopher.enumeration.Result;
import com.zd.christopher.fragment.HomeFragment;
import com.zd.christopher.fragment.MainMapFragment;
import com.zd.christopher.fragment.ParkingFragment;
import com.zd.christopher.fragment.VideoConfigFragment;
import com.zd.christopher.json.JsonForm;
import com.zd.christopher.json.JsonResult;

@SuppressLint("NewApi")
@SuppressWarnings("deprecation")
public class MainActivity extends ListActivity implements AnyChatBaseEvent
{
    private static final int IMAGE_REQUEST_CODE = 0;  
    private static final int RESIZE_REQUEST_CODE = 1;  

	private ImageButton avatar;
	
	private RadioGroup myTabRg;
	private HomeFragment home;
	private ParkingFragment parking;
	private MainMapFragment map;	
	private VideoConfigFragment me;
	
	private ActionBar action_bar;
    private DrawerLayout mDrawerLayout;
    private ListView list_view;
    private ArrayAdapter<CharSequence> list_items;
	private ActionBarDrawerToggle mDrawerToggle;
	private AdapterView.OnItemClickListener list_view_listener;
	
	private boolean exit_flag = false;
	
	private String directory_path = "//storage//sdcard0//VehicleManagement";

	private RequestQueue mQueue;
	
	public static AnyChatCoreSDK anyChatSDK;
	private final int LOCALVIDEOAUTOROTATION = 1; 	// 本地视频自动旋转控制
	private final int ACTIVITY_ID_MAINUI = 1; 	    // MainActivity的id标致，onActivityResult返回
	
	private String mStrIP = "192.168.1.104";
//	private String mStrIP = "demo.anychat.cn";
	private String mStrName = "";
	private int mSPort = 8182;
//	private int mSPort = 8906;
	
	protected static boolean exitAppFlag = false;
	protected static final ActivityController controller = ActivityController.getInstance();
	
	protected static final Handler exitAppHandler = new Handler()
	{
		public void handleMessage(Message msg) 
		{
			super.handleMessage(msg);
			exitAppFlag = false;
		}
	};
	
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
        if (keyCode == KeyEvent.KEYCODE_BACK) 
        	return exitApp();
        return super.onKeyDown(keyCode, event);
	}

	public boolean exitApp()
	{
        if (!exitAppFlag) 
        {
        	exitAppFlag = true;
            Toast.makeText(getApplicationContext(), getString(R.string.exit_app), Toast.LENGTH_SHORT).show();
            exitAppHandler.sendEmptyMessageDelayed(0, 2000);
        }
        else 
        	if(controller.exitApp())
    			return true;
    	return false;
	}

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());  
		setContentView(R.layout.main_activity);	
		
		controller.register(this);
		
		setActionBar();

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		
		initList();
        
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.tab_unread_bg, R.string.open, R.string.close)
        {
            public void onDrawerClosed(View view)
            {
                invalidateOptionsMenu(); 
            }
            public void onDrawerOpened(View drawerView)
            {
                invalidateOptionsMenu(); 
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        initAnyChat();
        loginAnyChat();
        
		initView();
		
		logId();
	}

	public void initView()
	{
		home = new HomeFragment();
		getFragmentManager().beginTransaction().replace(R.id.main_content, home)
			.commit();
		myTabRg = (RadioGroup) findViewById(R.id.tab_menu);
		myTabRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				switch (checkedId)
				{
					case R.id.rbHome:
							home = new HomeFragment();
						getFragmentManager().beginTransaction().replace(R.id.main_content, home)
							.commit();
						break;
					case R.id.rbParking:
							parking = new ParkingFragment();
						getFragmentManager().beginTransaction().replace(R.id.main_content, parking)
							.commit();
						break;
					case R.id.rbMap:
							map = new MainMapFragment();
						getFragmentManager().beginTransaction().replace(R.id.main_content, map)
							.commit();
						break;
					case R.id.rbMe:
							me = new VideoConfigFragment();
						getFragmentManager().beginTransaction().replace(R.id.main_content, me)
							.commit();
						break;
					default:
						break;
				}
			}
		});
	}
	
	public void initList()
	{
		list_items = ArrayAdapter.createFromResource(this, R.array.menu_list, android.R.layout.simple_list_item_1);
		setListAdapter(list_items);
		list_view = getListView();
		list_view_listener = new AdapterView.OnItemClickListener() 
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
			{
			   	mDrawerLayout.closeDrawer(Gravity.LEFT);
				if(position == 0)
			    	startActivity(new Intent(MainActivity.this, WebIndexActivity.class));
				else if(position == 1)
					startActivity(new Intent(MainActivity.this, MessageActivity.class));
				else if(position == 4)
					onItem4Click();
			}
		};
		list_view.setOnItemClickListener(list_view_listener);
		list_view.setBackground(this.getResources().getDrawable(R.drawable.menubg));
		
	}
	

	public boolean onOptionsItemSelected(MenuItem item) 
	{
        if (mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
	}

    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		
		avatar = (ImageButton) menu.findItem(R.id.avatar).getActionView();
		avatar.getBackground().setAlpha(0);
		if(DataBase.getAvatar(this, DataBase.getUser(this)).equals(""))
			avatar.setImageDrawable(getResources().getDrawable(R.drawable.avatar));
		else
		{
			Bitmap bitmap = BitmapFactory.decodeFile(DataBase.getAvatar(this, DataBase.getUser(this)));  
			Drawable drawable = new BitmapDrawable(bitmap);  
			avatar.setImageDrawable(drawable);
		}
		avatar.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
	            Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);  
	            galleryIntent.addCategory(Intent.CATEGORY_OPENABLE);  
	            galleryIntent.setType("image/*");  
	            startActivityForResult(galleryIntent, IMAGE_REQUEST_CODE);  
			}
		});
		
		return true;
	}
    
    public void resizeImage(Uri uri) 
    {  
        Intent intent = new Intent("com.android.camera.action.CROP");  
        intent.setDataAndType(uri, "image/*");  
        intent.putExtra("crop", "true");  
        intent.putExtra("aspectX", 1);  
        intent.putExtra("aspectY", 1);  
        intent.putExtra("outputX", 150);  
        intent.putExtra("outputY", 150);  
        intent.putExtra("return-data", true);  
        startActivityForResult(intent, RESIZE_REQUEST_CODE);  
    }  
  
    private void showAndSaveImage(Intent data) 
    {  
        Bundle extras = data.getExtras();  
        if (extras != null) 
        {  
            Bitmap photo = extras.getParcelable("data");  
            Drawable drawable = new BitmapDrawable(photo);  
            drawableTofile(drawable, directory_path);
            avatar.setImageDrawable(drawable);  
        }  
    } 
    
    public void drawableTofile(Drawable drawable,String path)
    {
		File file = new File(path);
        if(!file.exists())
        	file.mkdir();
        path = path +  "//" + DataBase.getUser(this) + ".JPEG";
        file = new File(path);
        DataBase.insertAvatar(this, DataBase.getUser(this), path);
		Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.JPEG, 100, bos);
		byte[] bitmapdata = bos.toByteArray();
		FileOutputStream fos;
		try 
		{
			fos = new FileOutputStream(file);
			fos.write(bitmapdata);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
    
    private void setActionBar()
    {
		action_bar = getActionBar();
		action_bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);  
		action_bar.setCustomView(R.layout.action_bar);
		action_bar.setIcon(R.drawable.menu);
		action_bar.setHomeButtonEnabled(true);
		action_bar.setDisplayShowHomeEnabled(true);
    }
    
    public void onItem4Click()
    {
    	  AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	  builder.setMessage("确认退出吗？");

    	  builder.setTitle("提示");

    	  builder.setPositiveButton("确认", new OnClickListener() 
    	  {
    		  public void onClick(DialogInterface dialog, int which) 
    		  {
    			  DataBase.deleteUser(getApplicationContext());
    			  DataBase.deleteId(getApplicationContext());
    			  DataBase.deleteUserName(getApplicationContext());
    			  dialog.dismiss();
    			  controller.exitApp();
    		  }
    	  });

    	  builder.setNegativeButton("取消", new OnClickListener()
    	  {
    	   public void onClick(DialogInterface dialog, int which)
    	   {
    		   dialog.dismiss();
    	   }
    	  });
    	  builder.create().show();
    }
    
    public void logId()
    {
		mQueue = Volley.newRequestQueue(this);  
		User user = new User(DataBase.getUser(this));
    	String jsonForm = "";
    	try
    	{
    		jsonForm = JsonForm.constructJsonForm(user);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	StringRequest stringRequest = null;
    	if(DataBase.getId(this) == 0)
    		stringRequest = new StringRequest(
    						"http://192.168.1.104:8181/Christopher/userAction_findByNaturalId.action?form=" + jsonForm,  
    						new Response.Listener<String>() 
    						{  
    							public void onResponse(String response) 
    							{  
    								JsonResult<User> jsonResult = null;
    								try
    								{
    									jsonResult = new Gson().fromJson(response, new TypeToken<JsonResult<User>>(){}.getType());
    									if(Result.SUCCESS == jsonResult.getResult())
    									{
    										DataBase.insertId(getApplicationContext(), jsonResult.getEntityList().get(0).getId());
    										DataBase.insertUserName(getApplicationContext(), jsonResult.getEntityList().get(0).getUserName());
    									}
    								}
    								catch(Exception e)
    								{
    									e.printStackTrace();
    								}
    							}  
    						}, 
						    new Response.ErrorListener() 
    						{  
    							public void onErrorResponse(VolleyError error)
    							{  
    								Toast.makeText(getApplicationContext(), "连接服务器失败", Toast.LENGTH_SHORT).show();
    							}  
    						});  
    	if(stringRequest != null)
    		mQueue.add(stringRequest);
    }
    
    public void initAnyChat()
    {
		anyChatSDK = AnyChatCoreSDK.getInstance(this);
		anyChatSDK.SetBaseEvent(this);
		anyChatSDK.InitSDK(android.os.Build.VERSION.SDK_INT, 0);
		AnyChatCoreSDK.SetSDKOptionInt(AnyChatDefine.BRAC_SO_LOCALVIDEO_AUTOROTATION, LOCALVIDEOAUTOROTATION);
    }
    
    public void loginAnyChat()
    {
		mStrName = DataBase.getUser(this);
		anyChatSDK.Connect(mStrIP, mSPort);
        anyChatSDK.Login(DataBase.getUserName(this), "123456");
        anyChatSDK.EnterRoom(8181, "");
    }

	protected void onPause()
	{
		super.onPause();
	}

	protected void onDestroy() 
	{
		super.onDestroy();
	}

	protected void onResume() 
	{
		super.onResume();	
	}

	protected void onRestart() 
	{
		super.onRestart();
	}

	public void OnAnyChatConnectMessage(boolean bSuccess) 
	{

	}

	public void OnAnyChatLoginMessage(int dwUserId, int dwErrorCode)
	{

	}

	public void OnAnyChatEnterRoomMessage(int dwRoomId, int dwErrorCode)
	{
		
	}

	public void OnAnyChatOnlineUserMessage(int dwUserNum, int dwRoomId)
	{
		
	}

	public void OnAnyChatUserAtRoomMessage(int dwUserId, boolean bEnter)
	{
		
	}

	public void OnAnyChatLinkCloseMessage(int dwErrorCode) 
	{

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) 
		{  
	    	case IMAGE_REQUEST_CODE:  
	    		resizeImage(data.getData());  
	            break;  	  
	        case RESIZE_REQUEST_CODE:  
	            if (data != null)  
	                showAndSaveImage(data);  
	            break;  
	    }  
	}
	
}
