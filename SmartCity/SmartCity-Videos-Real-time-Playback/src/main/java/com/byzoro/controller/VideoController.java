package com.byzoro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byzoro.service.impl.ServiceImpl;

@Controller
@RequestMapping("/native")
public class VideoController {
	@Autowired
	private ServiceImpl serviceimpl;
	
	@RequestMapping("/pullVideo")
	public void pullToRtmp(HttpServletRequest request) throws InterruptedException {
		//TODO: 推流：将本地视频推送到rtmp服务器
//		serviceimpl.ffplay("D:\\video\\345.mp4");
		
		//TODO: 推流：监控摄像头推送到rtmp服务器
		serviceimpl.ffplay();
	}
	
	
	@RequestMapping("/saveVideo")
	public void saveToLocal() throws InterruptedException {
		//TODO: 将监控视频保存到本地
		serviceimpl.ffmpegSaveToLocal();
	}
}
