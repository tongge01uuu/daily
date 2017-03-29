package daily.java.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by phantom on 2017/3/29.
 */
public class ProxyCglib {
    public static void main(String[] args) {
        SourceObjectService sourceObjectService=new SourceObjectServiceImpl();
        SourceObjectService proxyObject=(SourceObjectService)new CGlibProxyFactory(sourceObjectService).getProxyInstance();
        proxyObject.saveSourceObject();
        proxyObject.getSourceObject();
    }
}

class CGlibProxyFactory implements MethodInterceptor
{
    private Object target;
    public CGlibProxyFactory(Object target)
    {
        this.target=target;
    }

    public Object getProxyInstance()
    {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置代理目标类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log();
        Object result=method.invoke(target,objects);
        return result;
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
