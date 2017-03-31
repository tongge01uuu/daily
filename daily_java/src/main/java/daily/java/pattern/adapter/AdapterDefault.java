package daily.java.pattern.adapter;

/**
 * Created by yukai on 2017/3/31.
 */

/**
 * 缺省适配模式
 * 如果不准备实现一个接口的所有方法时，
 * 就可以使用“缺省适配模式”制造一个抽象类，给出所有方法的平庸的具体实现。
 * 这样，从这个抽象类再继承下去的子类就不必实现所有的方法。
 * 只选择它所需要的方法实现，而不必理会其他的不需要的方法。
 *
 */
public class AdapterDefault {
    public static void main(String[] args) {
        DefaultAdapter adapter=new DefaultAdapter();
        adapter.operation1();
    }

}
class DefaultAdapter extends ServiceAdapter
{
    public void operation1()
    {
        log();
    }
}
class ServiceAdapter implements ServiceInterface
{
    @Override
    public void operation1() {
        log();
    }

    @Override
    public void operation2() {
        log();
    }

    @Override
    public void operation3() {
        log();
    }
    public void log()
    {
        //调用方法的方法名
        String methodName=new Exception().getStackTrace()[1].getMethodName();
        String className=this.getClass().getName();
        String classInfo=this.toString();
        System.out.println(String.format("执行对象：%s（%s）的方法:%s",className,classInfo,methodName));
    }
}
interface ServiceInterface
{
    public void operation1();
    public void operation2();
    public void operation3();
}
