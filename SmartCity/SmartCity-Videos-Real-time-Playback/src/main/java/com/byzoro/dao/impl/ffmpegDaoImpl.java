package com.byzoro.dao.impl;

import org.springframework.stereotype.Repository;

import com.byzoro.dao.ffmpegDao;
import com.byzoro.manager.FFmpegManager;
import com.byzoro.manager.impl.FFmpegManagerImpl;
@Repository
public class ffmpegDaoImpl implements ffmpegDao{
	public  void ffplay(String path) throws InterruptedException{
		FFmpegManager manager = new FFmpegManagerImpl();
		//将本地视频推到rtmp服务器
		manager.start("tomcat ","ffmpeg -re -i E:\\video\\345.mp4 -vcodec copy -acodec copy -f flv rtmp://node-3:1935/myapp/test1");
		//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		manager.stopAll();
	}

	public void ffplay() {
		FFmpegManager manager = new FFmpegManagerImpl();
		//推本地摄像头到rtmp服务器
//		manager.start("tomcat", "ffmpeg -f dshow -i video=\"Integrated Camera\" -vcodec libx264 -acodec copy -f flv rtmp://node03:1935/myapp/test1");
		//将监控摄像头推到rtmp服务器
		manager.start("tomcat ","ffmpeg -i rtsp://admin:admin123@10.8.3.4 -vcodec copy -acodec aac -ar 44100 -strict -2 -ac 1 -f flv -s 1280x720 -q 10 -f flv rtmp://node-3:1935/myapp/test1");
	}

	@Override
	public void ffmpegSaveToLocal() {
		FFmpegManager manager = new FFmpegManagerImpl();
		manager.start("存视频到本地:","ffmpeg -i rtmp://node-3:1935/myapp/test1 -c copy D:\\video\\fdsfdsfdsafa.mp4");
		System.out.println("存储。。。。。。");
	}
}


