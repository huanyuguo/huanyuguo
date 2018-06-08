package com.byzoro.version2.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;

import com.byzoro.version2.MTProxyService;
import sun.misc.BASE64Decoder;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(endpointInterface="com.byzoro.version2.MTProxyService"
	,targetNamespace="http://impl.service.guotou.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class MTProxyServiceImpl implements MTProxyService {
	public String AlarmInform(String cameraId,
                              String alarmType, String alarmTime,
                              String alarmPicture) {

        System.out.println(cameraId+" "+alarmType
                +" "+ alarmTime+" "+alarmPicture);

        boolean result = false;
		String remark = null;
		try {
		    //TODO: base64解码
			BASE64Decoder decoder = new BASE64Decoder();
            /**
             * @Describe TODO: 存储告警图片到本地指定路径下
             **/
            byte[] b = decoder.decodeBuffer(alarmPicture);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            String imgFilePath = System.getProperty("user.dir")
                    + File.separator + "picture"
                    + File.separator + cameraId +new Random().nextInt(1000)+ ".jpg";
            OutputStream out = new FileOutputStream(imgFilePath);
            System.out.println(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

			result = true;
		} catch (Exception e) {
			result = false;
			remark = e.getMessage();
		}finally{
            System.out.println("Server执行完成");
            return "返回结果:"+result+"  异常信息："+remark;
		}
	}
}
