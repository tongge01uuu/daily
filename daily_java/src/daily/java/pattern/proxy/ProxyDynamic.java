package daily.java.pattern.proxy;

import java.lang.reflect.*;

/**
 * Created by yukai on 2017/3/29.
 */
public class ProxyDynamic {
    public static void main(String[] args) {
        SourceObjectService sourceObjectService=new SourceObjectServiceImpl();
        ProxyFactory proxyFactory=new ProxyFactory(sourceObjectService);
        SourceObjectService proxy=(SourceObjectService)proxyFactory.getProxyInstance();
//        proxy.saveSourceObject();
        proxy.getSourceObject();
    }
}

class ProxyFactory{
    private Object target;
    public ProxyFactory(Object target)
    {
        this.target=target;
    }

    public Object getProxyInstance()
    {
        Object object= Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *  @param   proxy the proxy instance that the method was invoked on
                     *  一开始把proxy 误传成 target 对象，结果陷入了循环代理的死循环
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        log();
                        Object object=method.invoke(target,args);
                        return object;
                    }
                }
        );
        return object;
    }

    private void log()
    {
        //调用方法的方法名
        String methodName=new Exception().getStackTrace()[1].getMethodName();
        String className=this.getClass().getName();
        String classInfo=this.toString();
        System.out.println(String.format("执行代理对象：%s（%s）的方法:%s",className,classInfo,methodName));
    }
}