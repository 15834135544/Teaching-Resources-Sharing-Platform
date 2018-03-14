package com.zd.christopher.config;

public class ConfigEntity {
	public static final int VIDEO_MODE_SERVERCONFIG = 0;	// 服务器视频参数配�?
	public static final int VIDEO_MODE_CUSTOMCONFIG = 1;	// 自定义视频参数配�?
	
	public static final int VIDEO_QUALITY_NORMAL = 2;		// 普�?�视频质�?
	public static final int VIDEO_QUALITY_GOOD = 3;			// 中等视频质量
	public static final int VIDEO_QUALITY_BEST = 4;			// 较好视频质量
	
	public int mConfigMode = VIDEO_MODE_SERVERCONFIG;
	public int mResolutionWidth = 0;
	public int mResolutionHeight = 0;
	
	public int mVideoBitrate = 150*1000;					// 本地视频码率
	public int mVideoFps = 10;								// 本地视频帧率
	public int mVideoQuality = VIDEO_QUALITY_GOOD;
	public int mVideoPreset = 1;
	public int mVideoOverlay = 1;							// 本地视频是否采用Overlay模式
	public int mVideoRotateMode = 0;						// 本地视频旋转模式
	public int mFixColorDeviation = 0;						// 修正本地视频采集偏色�?0 关闭(默认）， 1 �?�?
	public int mVideoShowGPURender = 0;						// 视频数据通过GPU直接渲染�?0  关闭(默认)�? 1 �?�?
	public int mVideoAutoRotation = 1;						// 本地视频自动旋转控制（参数为int型， 0表示关闭�? 1 �?启[默认]，视频旋转时�?要参考本地视频设备方向参数）
	
	public int mEnableP2P = 1;
	public int mUseARMv6Lib = 0;							// 是否强制使用ARMv6指令集，默认是内核自动判�?
	public int mEnableAEC = 1;								// 是否使用回音消除功能
	public int mUseHWCodec = 0;								// 是否使用平台内置硬件编解码器
}
