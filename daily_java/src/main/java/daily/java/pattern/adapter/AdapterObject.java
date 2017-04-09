package daily.java.pattern.adapter;

/**
 * Created by yukai on 2017/3/31.
 */

/**
 * 对象适配模式
 * Adaptee类并没有operation2()方法，而客户端则期待这个方法。
 * 为使客户端能够使用Adaptee类，需要提供一个包装(Wrapper)类Adapter。
 * 这个包装类包装了一个Adaptee的实例，从而此包装类能够把Adaptee的API与Target类的API衔接起来。
 * Adapter与Adaptee是委派关系，这决定了适配器模式是对象的
 */
public class AdapterObject {
    public static void main(String[] args) {
        Adaptee adaptee=new Adaptee();
        ObjectAdapter adapter=new ObjectAdapter(adaptee);
        adapter.operation1();
        adapter.operation2();
    }
}

class ObjectAdapter {
    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee){
        this.adaptee=adaptee;
    }

    public void operation1() {
        log();
        adaptee.operation1();
    }

    public void operation2() {
        log();
    }
    private void log()
    {
        //调用方法的方法名
        String methodName=new Exception().getStackTrace()[1].getMethodName();
        String className=this.getClass().getName();
        String classInfo=this.toString();
        System.out.println(String.format("执行对象：%s（%s）的方法:%s",className,classInfo,methodName));
    }
}