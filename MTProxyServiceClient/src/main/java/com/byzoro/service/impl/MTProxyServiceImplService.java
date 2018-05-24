
package com.byzoro.service.impl;

import com.byzoro.service.MTProxyService;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author huanyuguo
 * @date 2018/5/24 9:11
**/
@WebServiceClient(name = "MTProxyServiceImplService", targetNamespace = "http://impl.service.guotou.com/", wsdlLocation = "http://localhost:8888/uploadFileService?wsdl")
public class MTProxyServiceImplService
    extends Service
{

    private final static URL MTPROXYSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MTPROXYSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName MTPROXYSERVICEIMPLSERVICE_QNAME = new QName("http://impl.service.guotou.com/", "MTProxyServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/uploadFileService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MTPROXYSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        MTPROXYSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public MTProxyServiceImplService() {
        super(__getWsdlLocation(), MTPROXYSERVICEIMPLSERVICE_QNAME);
    }

    public MTProxyServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MTPROXYSERVICEIMPLSERVICE_QNAME, features);
    }

    public MTProxyServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, MTPROXYSERVICEIMPLSERVICE_QNAME);
    }

    public MTProxyServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MTPROXYSERVICEIMPLSERVICE_QNAME, features);
    }

    public MTProxyServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MTProxyServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MTProxyService
     */
    @WebEndpoint(name = "MTProxyServiceImplPort")
    public MTProxyService getMTProxyServiceImplPort() {
        return super.getPort(new QName("http://impl.service.guotouu.com/", "MTProxyServiceImplPort"), MTProxyService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MTProxyService
     */
    @WebEndpoint(name = "MTProxyServiceImplPort")
    public MTProxyService getMTProxyServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.service.guotou.com/", "MTProxyServiceImplPort"), MTProxyService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MTPROXYSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw MTPROXYSERVICEIMPLSERVICE_EXCEPTION;
        }
        return MTPROXYSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
