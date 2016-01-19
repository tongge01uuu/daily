package cn.outofmemory.hello.apache.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface HelloService {

	@WebMethod
	@WebResult String hello(@WebParam String who);
	
}
