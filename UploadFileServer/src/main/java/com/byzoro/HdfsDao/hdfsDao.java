package com.byzoro.HdfsDao;


import java.io.File;

public interface HdfsDao {
//	TODO: 将本地视频流保存到HDFS;
	public void copyToHdfs(File localPath) throws Exception;

	public void uploadFile() throws Exception;

	public void downloadFile() throws Exception;

	public void deleteFile() throws Exception;

	public void uploadFile2() throws Exception;




}
