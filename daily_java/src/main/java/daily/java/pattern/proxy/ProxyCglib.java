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

/**
 * ASM用途
 * asm字节码增强技术主要是用来反射的时候提升性能的，如果单纯用jdk的反射调用，性能是非常低下的，
 * 而使用字节码增强技术后反射调用的时间已经基本可以与直接调用相当了
 * CGLIB是对ASM的封装，简化了ASM的操作，降低了ASM的使用门槛
 */
/**
 * ASM介绍
 * ASM是一个java字节码操纵框架，它能被用来动态生成类或者增强既有类的功能。
 * ASM 可以直接产生二进制 class 文件，也可以在类被加载入 Java 虚拟机之前动态改变类行为。
 * Java class 被存储在严格格式定义的 .class文件里，
 * 这些类文件拥有足够的元数据来解析类中的所有元素：类名称、方法、属性以及 Java 字节码（指令）。
 * ASM从类文件中读入信息后，能够改变类行为，分析类信息，甚至能够根据用户要求生成新类。
 */

/**
 * Cglib代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展.
 * JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用Cglib实现.
 * Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.它广泛的被许多AOP的框架使用,例如Spring AOP和synaop,为他们提供方法的interception(拦截)
 * Cglib包的底层是通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类.
 * 不鼓励直接使用ASM,因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉.
 * Cglib子类代理实现方法:
 * 1.需要引入cglib的jar文件,但是Spring的核心包中已经包括了Cglib功能,所以直接引入spring-core-3.2.5.jar即可.
 *   【注意】：如果不是spring工程中需要引入cglib-nodep包，因为cglib中没有asm（org/objectweb/asm/Type）
 * 2.引入功能包后,就可以在内存中动态构建子类
 * 3.代理的类不能为final,否则报错
 * 4.目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
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
