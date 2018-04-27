package com.byzoro.dao.impl;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import com.byzoro.dao.hdfsDao;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

public class hdfsDaoImpl implements hdfsDao {

    @Override
    /**
     *  TODO: 上传视频流到hdfs
     */
    public void copyToHdfs() throws Exception {
        //TODO: 创建Configuration对象
        Configuration conf = new Configuration();
        //TODO: 连接远程hdfs
        FileSystem hdfsFileSystem = null;
        try {
            hdfsFileSystem = FileSystem.get(new URI("hdfs://node01:9000"), conf);
        } catch (URISyntaxException e) {
            throw new Exception("===============hdfs连接失败===============");
        }
        System.out.println("===============hdfs已连接===============");
        //TODO: 创建两个FileSystem对象
//        FileSystem sendhdfs = FileSystem.get(conf);
        FileSystem localFileSystem = FileSystem.getLocal(conf);
        //TODO: 确定需要上传的视频流本地路径，相当于设置"缓存区"中文件的路径
        Path localPath = new Path("D:/file/word.txt");
        //TODO: 设置接收视频流路径，在HDFS系统上的/byzoro/video 路径下接收视频流数据

        FileStatus[] fileStatus = localFileSystem.listStatus(localPath);
        System.out.println(fileStatus);
        FSDataOutputStream outputStream;
        //TODO: 循环写入视频文件到HDFS
        for (int i = 0; i < fileStatus.length; i++) {
            System.out.println("上传的文件名是:" + fileStatus[i].getPath().getName());
            FSDataInputStream inputStream = localFileSystem.open(fileStatus[i].getPath());
            outputStream = hdfsFileSystem.create(new Path("/byzoro/file/" + fileStatus[i].getPath().getName()));
            byte[] buffer = new byte[256];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }
            //TODO: 上传一个文件结束后关闭流
            outputStream.close();
            inputStream.close();
            //TODO: 获取文件路径
            File file = new File(fileStatus[i].getPath().toString().substring(5));
            //TODO: 上传完成后删除本地文件
            file.delete();
        }
    }

    @Override
    public void uploadFile() throws Exception {
        Configuration conf = new Configuration();
        //TODO: hadoop文件系统
        try {
            //TODO: 连接hdfs
            FileSystem fs = FileSystem.get(new URI("hdfs://node01:9000"), conf);
            //TODO: 指定上传的本地文件
            FileInputStream in = new FileInputStream("D:/file/words.txt");
//            FileInputStream in = new FileInputStream("D:/video/345.mp4");
            //TODO:指定上传到hdfs的路径及重新命名文件名
            FSDataOutputStream out = fs.create(new Path("/byzoro/file/hdfswords2.txt"));
//            FSDataOutputStream out = fileSystem.create(new Path("/byzoro/spark/zhuoyaoji.mp4"));
            //TODO: 上传本地文件到hdfs文件系统
            IOUtils.copyBytes(in, out, conf);
            System.out.println("===============上传完毕===============");
            //TODO: 关闭文件系统
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("===============上传失败===============");
        }
    }

    @Override
    public void uploadFile2() throws Exception {
        String hdfsAddress="hdfs://node01:9000";
        String localSrc = "D:/file/12345678.txt";
        String dst = "/byzoro/file/test.txt";


        InputStream in = new BufferedInputStream(new FileInputStream(localSrc));

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(hdfsAddress), conf);
        OutputStream out = fs.create(new Path(dst), new Progressable() {
            @Override
            public void progress() {
                System.out.println("......");
            }
        });

        IOUtils.copyBytes(in, out, 4096, true);
    }

    @Override
    public void downloadFile() throws Exception {
        //TODO: 从hdfs下载文件
        Configuration conf = new Configuration();
        try {
            FileSystem fileSystem = FileSystem.get(new URI("hdfs://node01:9000"), conf);

            FSDataInputStream input = fileSystem.open(new Path("hdfs://node01:9000/byzoro/file/word.txt"));
            FileOutputStream out = new FileOutputStream("D:/file/12345678.txt");
            IOUtils.copyBytes(input, out, conf);
            fileSystem.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("===============下载失败===============");
        }
        System.out.println("===============下载完成===============");
    }

    @Override
    public void deleteFile() throws Exception {
        //TODO: 删除hdfs文件
        Configuration conf = new Configuration();
        try {
            FileSystem fileSystem = FileSystem.get(new URI("hdfs://node01:9000"), conf);

            fileSystem.delete(new Path("hdfs://node01:9000/test.log"));
            fileSystem.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===============删除成功===============");
    }

}
