package com.byzoro;import com.byzoro.com.guotou.service.impl.MTProxyService;import com.byzoro.com.guotou.service.impl.MTProxyServiceImplService;import sun.misc.BASE64Encoder;import java.io.FileInputStream;import java.io.IOException;import java.io.InputStream;/** * @author huanyuguo * @date 2018/4/26 17:22 */public class Client {    public static void main(String[] args) throws IOException {        MTProxyServiceImplService mtProxyServiceImplService = new MTProxyServiceImplService();        MTProxyService service = mtProxyServiceImplService.getMTProxyServiceImplPort();        String filename = "test.mp4";        String imgFile1 = "D:\\file\\test111.jpg";        String imgFile2 = "D:\\video\\test.mp4";        InputStream inputStream1 = null;        InputStream inputStream2 = null;        byte[] data1 = null;        byte[] data2 = null;        try {            inputStream1 = new FileInputStream(imgFile1);            inputStream2 = new FileInputStream(imgFile2);            data1 = new byte[inputStream1.available()];            data2 = new byte[inputStream2.available()];            inputStream1.read(data1);            inputStream1.close();            inputStream2.read(data2);            inputStream2.close();        } catch (IOException e) {            e.printStackTrace();        }        // TODO: 加密        BASE64Encoder encoder = new BASE64Encoder();        String alarmPicture= encoder.encode(data1);        String alarmVideo= encoder.encode(data2);        service.alarmInform("001",filename,"4","2018-04-25 11:20:35",                alarmPicture,alarmVideo);        System.out.println("Client执行成功。。。");    }}