package com.byzoro.dao;

public interface ffmpegDao {
	//将本地视频推到rtmp服务器
	public void ffplay(String path) throws InterruptedException;
	//将监控摄像头推到rtmp服务器
	public void ffplay();
	//将监控视频保存到本地
	public void ffmpegSaveToLocal();
	
}
