package com.byzoro.service.impl;

import org.springframework.stereotype.Service;

import com.byzoro.dao.ffmpegDao;
import com.byzoro.dao.impl.ffmpegDaoImpl;
import com.byzoro.service.VideoService;

@Service
public class ServiceImpl implements VideoService{
    private ffmpegDao ffmpegDaoimpl=new ffmpegDaoImpl();
    
	public void ffplay(String path) throws InterruptedException {
		ffmpegDaoimpl.ffplay(path);
	}
	public void ffplay() {
		ffmpegDaoimpl.ffplay();
		
	}
	public void ffmpegSaveToLocal() {
		ffmpegDaoimpl.ffmpegSaveToLocal();
	}
}
