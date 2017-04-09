package daily.java.pattern.adapter;

/**
 * Created by yukai on 2017/3/31.
 */

/**
 * 类适配器模式
 * 模式所涉及的角色有：
 　　1、目标(Target)角色：这就是所期待得到的接口。
        注意：由于这里讨论的是类适配器模式，因此目标不可以是类。
 　　2、源(Adapee)角色：现在需要适配的接口。
 　　3、适配器(Adaper)角色：适配器类是本模式的核心。
        适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 */
public class AdapterClass {
    public static void main(String[] args) {
        ClassAdapter adapter=new ClassAdapter();
        adapter.operation1();
        adapter.operation2();
    }
}
class ClassAdapter extends Adaptee implements Target
{
    @Override
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