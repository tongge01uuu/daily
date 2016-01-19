package cn.outofmemory.hello.apache.cxf;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ServiceClient {
	public static void main(String[] args) {  
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        factory.setServiceClass(HelloService.class);  
        factory.setAddress("http://localhost:9000/ws/HelloService");  
        //访问地址：http://localhost:9000/ws/HelloService?wsdl
        HelloService helloworld = (HelloService) factory.create();  
        System.out.println(helloworld.hello("outofmemory.cn"));  
        System.exit(0);  
    }  
}
