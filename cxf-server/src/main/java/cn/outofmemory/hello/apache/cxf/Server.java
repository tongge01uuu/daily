package cn.outofmemory.hello.apache.cxf;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

	
	public static void main(String[] args) throws Exception {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();  
        factory.setServiceClass(SimpleHelloService.class);  
          
        /**
         * 客户端代码生成指令：
         * ./wsdl2java -d /Users/phantom/Desktop/ -p com.test.cxf http://localhost:9000/ws/HelloService?wsdl
         * 
         */
        factory.setAddress("http://localhost:9000/ws/HelloService");  
        factory.create();  
  
        System.out.println("Server start...");  
	}
}
