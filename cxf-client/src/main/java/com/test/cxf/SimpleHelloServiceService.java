package com.test.cxf;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-11-27T15:19:20.784+08:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "SimpleHelloServiceService", 
                  wsdlLocation = "http://localhost:9000/ws/HelloService?wsdl",
                  targetNamespace = "http://cxf.apache.hello.outofmemory.cn/") 
public class SimpleHelloServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://cxf.apache.hello.outofmemory.cn/", "SimpleHelloServiceService");
    public final static QName SimpleHelloServicePort = new QName("http://cxf.apache.hello.outofmemory.cn/", "SimpleHelloServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:9000/ws/HelloService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SimpleHelloServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:9000/ws/HelloService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SimpleHelloServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SimpleHelloServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SimpleHelloServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SimpleHelloServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SimpleHelloServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SimpleHelloServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns HelloService
     */
    @WebEndpoint(name = "SimpleHelloServicePort")
    public HelloService getSimpleHelloServicePort() {
        return super.getPort(SimpleHelloServicePort, HelloService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloService
     */
    @WebEndpoint(name = "SimpleHelloServicePort")
    public HelloService getSimpleHelloServicePort(WebServiceFeature... features) {
        return super.getPort(SimpleHelloServicePort, HelloService.class, features);
    }

}
