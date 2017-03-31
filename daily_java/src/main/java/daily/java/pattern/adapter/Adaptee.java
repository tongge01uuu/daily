package daily.java.pattern.adapter;

/**
 * Created by yukai on 2017/3/31.
 */
public class Adaptee {

    public void operation1() {
        log();
    }

    private void log() {
        //调用方法的方法名
        String methodName = new Exception().getStackTrace()[1].getMethodName();
        String className = this.getClass().getName();
        String classInfo = this.toString();
        System.out.println(String.format("执行对象：%s（%s）的方法:%s", className, classInfo, methodName));
    }
}
