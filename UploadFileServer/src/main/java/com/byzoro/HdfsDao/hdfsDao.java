package com.byzoro.HdfsDao;

import java.io.IOException;
import java.net.URISyntaxException;

public interface hdfsDao {
//	TODO: 将视频存储到HDFS;
	public void copyToHdfs() throws Exception;
	public void uploadFile() throws Exception;
	public void downloadFile() throws Exception;
	public void deleteFile() throws Exception;
	public void uploadFile2() throws Exception;




}
