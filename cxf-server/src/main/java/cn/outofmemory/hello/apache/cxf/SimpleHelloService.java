package cn.outofmemory.hello.apache.cxf;

public class SimpleHelloService implements HelloService {

	public String hello(String who) {
		return "hello " + who;
	}

}
