package com.byzoro;import javax.activation.DataHandler;import javax.jws.WebService;import javax.jws.soap.SOAPBinding;import java.io.*;import java.util.UUID;/** * @author huanyuguo * @date 2018/4/26 15:10 */@WebService(endpointInterface="com.byzoro.UploadFileInterface")@SOAPBinding(style = SOAPBinding.Style.RPC)public class UploadFile implements UploadFileInterface {    public String AlarmInform(String cameraId, String alarmType, String alarmTime, FileSources fileSources) {        System.out.println(cameraId + "=====" + alarmType + "=====" + alarmTime);        String uuid = UUID.randomUUID().toString();        String fileName = cameraId + uuid+".mp4";        DataHandler dataHandler = fileSources.getVideoDataHandler();        if (cameraId != null && alarmType != null && alarmTime != null) {            File file = new File("D:\\uploadVideo\\" + fileName);            if (null != dataHandler) {                InputStream is = null;                FileOutputStream fos = null;                try {                    is = dataHandler.getInputStream();                    fos = new FileOutputStream(file);                    byte[] buff = new byte[1024 * 8];                    int len = 0;                    while ((len = is.read(buff)) > 0) {                        fos.write(buff, 0, len);                    }                } catch (FileNotFoundException e) {                    return "fileNotFound";                } catch (Exception e) {                    return "upload File failure";                } finally {                    try {                        if (fos != null) {                            fos.flush();                            fos.close();                        }                        if (is != null) {                            is.close();                        }                    } catch (Exception e) {                        e.printStackTrace();                    }                }                return "file absolute path:" + file.getAbsolutePath();            } else {                return "dataHandler is null";            }        } else {            return "fileName is null";        }    }}