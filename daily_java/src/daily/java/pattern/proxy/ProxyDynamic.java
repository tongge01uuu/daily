package daily.java.pattern.proxy;

import java.lang.reflect.*;

/**
 * Created by yukai on 2017/3/29.
 */

/**
 * JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用Cglib实现.
 * 在Spring的AOP编程中:
 * 如果加入容器的目标对象有实现接口,用JDK代理
 * 如果目标对象没有实现接口,用Cglib代理
 */
public class ProxyDynamic {
    public static void main(String[] args) {
        SourceObjectService sourceObjectService=new SourceObjectServiceImpl();
        ProxyFactory proxyFactory=new ProxyFactory(sourceObjectService);
        SourceObjectService proxy=(SourceObjectService)proxyFactory.getProxyInstance();
        proxy.saveSourceObject();
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
        /**
         * newProxyInstance 三个参数的释义：
         * ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
         * Class<?>[] interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
         * InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
         */
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