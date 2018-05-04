package com.byzoro.HdfsDao.impl;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

import com.byzoro.HdfsDao.HdfsDao;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HdfsDaoImpl implements HdfsDao {

    /**
     * @param file 需要上传的视频文件
     * @throws Exception TODO: 上传视频流到hdfs
     */
    @Override
    public void copyToHdfs(File file) throws Exception {
        //TODO: 创建Configuration对象
        Configuration conf = new Configuration();
        //TODO: 连接远程hdfs
        FileSystem hdfsFileSystem = null;
        try {
            hdfsFileSystem = FileSystem.get(new URI("hdfs://10.8.1.200:9000"), conf);
        } catch (URISyntaxException e) {
            throw new Exception("hdfs连接失败");
        }
        System.out.println("hdfs已连接");
        //TODO: 创建FileSystem对象
        FileSystem localFileSystem = FileSystem.getLocal(conf);
        //TODO: 获取文件绝对路径
        String fileAbsolutePath = file.getAbsolutePath();
        //TODO: 确定需要上传的视频流本地路径，相当于设置"缓存区"中文件的路径
        Path localPath = new Path(fileAbsolutePath);
        //TODO: 设置接收视频流路径，在HDFS系统上的/byzoro/spark 路径下接收视频流数据
        FileStatus[] fileStatus = localFileSystem.listStatus(localPath);

        FSDataOutputStream outputStream;
        //TODO: 循环写入视频文件到HDFS
        for (int i = 0; i < fileStatus.length; i++) {
            FSDataInputStream inputStream = localFileSystem.open(fileStatus[i].getPath());
            Path hdfsPath = new Path("/byzoro/spark/" + file.getName());
            outputStream = hdfsFileSystem.create(hdfsPath);
            byte[] buffer = new byte[256];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }
            //TODO: 上传一个文件结束后关闭流
            outputStream.close();
            inputStream.close();
            System.out.println("已上传。。。。。。");
            System.out.println(hdfsPath);

            //TODO: 上传完成后删除本地文件
            file.delete();
        }
    }
}

