package com.byzoro;import javax.xml.ws.Endpoint;/** * @author huanyuguo * @date 2018/4/26 15:13 */public class Server {    public static void main(String[] args) {        //TODO: wsdl访问路径  http://localhost:8888/uploadFileService?wsdl        String address="http://localhost:8888/uploadFileService";        //TODO: 配置路径与该路径下的接口实现类        Endpoint.publish(address, new UploadFile());        System.out.println("UploadFile() 发布成功。。。。。。");    }}