package com.byzoro;import com.byzoro.HdfsDao.HdfsDao;import com.byzoro.HdfsDao.impl.HdfsDaoImpl;import javax.activation.DataHandler;import javax.jws.WebService;import javax.jws.soap.SOAPBinding;import java.io.*;import java.util.UUID;/** * @author huanyuguo * @date 2018/4/26 15:10 */@WebService(endpointInterface = "com.byzoro.UploadFileInterface")@SOAPBinding(style = SOAPBinding.Style.RPC)public class UploadFile implements UploadFileInterface {    public String AlarmInform(String cameraId, String fileName,String alarmType, String alarmTime, FileSources fileSources) throws Exception {        String uuid = UUID.randomUUID().toString();        //TODO: 定义接收的视频文件名称        System.out.println(fileName);        String newFileName = cameraId + uuid + fileName.substring(fileName.lastIndexOf("."));        DataHandler dataHandler = fileSources.getVideoDataHandler();        if (cameraId != null && alarmType != null && alarmTime != null) {            //TODO: 远程接收视频文件暂存的本地路径            File file = new File("D:\\uploadVideo\\" + newFileName);            if (null != dataHandler) {                InputStream is = null;                FileOutputStream fos = null;                try {                    is = dataHandler.getInputStream();                    fos = new FileOutputStream(file);                    byte[] buff = new byte[1024 * 8];                    int len = 0;                    while ((len = is.read(buff)) > 0) {                        fos.write(buff, 0, len);                    }                } catch (FileNotFoundException e) {                    return "fileNotFound";                } catch (Exception e) {                    return "upload File failure";                } finally {                    try {                        if (fos != null) {                            fos.flush();                            fos.close();                        }                        if (is != null) {                            is.close();                        }                    } catch (Exception e) {                        e.printStackTrace();                    }                    //TODO:将视频流上传到hdfs                    HdfsDao hdfsDao = new HdfsDaoImpl();                    hdfsDao.copyToHdfs(file);                }                return "file absolute path:" + file.getAbsolutePath();            } else {                return "dataHandler is null";            }        } else {            return "fileName is null";        }    }}