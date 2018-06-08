package com.byzoro.version2;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @Describe 
 * @Param 
 * @return 
 * @author huanyuguo
 * @date 2018/5/23 20:04
**/
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MTProxyService {
    public String AlarmInform(@WebParam(name = "cameraID") String cameraId,
                              @WebParam(name = "alarmType") String alarmType,
                              @WebParam(name = "alarmTime") String alarmTime,
                              @WebParam(name = "alarmPicture") String alarmPicture);

}
                              
                              
                              

