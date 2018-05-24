
package com.byzoro.service;

import com.byzoro.ObjectFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import java.util.ArrayList;

/**
 * @author huanyuguo
 * @date 2018/5/24 9:11
**/
@WebService(name = "MTProxyService", targetNamespace = "http://version2.byzoro.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MTProxyService {

    /**
     * 
     * @param fileName
     * @param alarmType
     * @param alarmVideo
     * @param cameraID
     * @param alarmTime
     * @param alarmPicture
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "AlarmInform")
    @WebResult(partName = "return")
    @Action(input = "http://version2.byzoro.com/MTProxyService/AlarmInformRequest", output = "http://version2.byzoro.com/MTProxyService/AlarmInformResponse")
    public String alarmInform(
        @WebParam(name = "cameraID", partName = "cameraID")
        String cameraID,
        @WebParam(name = "fileName", partName = "fileName")
        String fileName,
        @WebParam(name = "alarmType", partName = "alarmType")
        ArrayList alarmType,
        @WebParam(name = "alarmTime", partName = "alarmTime")
        String alarmTime,
        @WebParam(name = "alarmPicture", partName = "alarmPicture")
        String alarmPicture,
        @WebParam(name = "alarmVideo", partName = "alarmVideo")
        String alarmVideo);

}
