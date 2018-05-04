package com.byzoro.HdfsDao;


import java.io.File;


public interface HdfsDao {
    /**
     *
     * @param file
     * @throws Exception
     * TODO: 将本地视频流保存到HDFS;
     */

	public void copyToHdfs(File file) throws Exception;
}
