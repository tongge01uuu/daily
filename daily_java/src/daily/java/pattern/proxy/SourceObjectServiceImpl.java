package daily.java.pattern.proxy;

/**
 * Created by yukai on 2017/3/29.
 */
public class SourceObjectServiceImpl implements SourceObjectService
{

    @Override
    public Object getSourceObject() {
        log();
        return new Object();
    }

    @Override
    public void saveSourceObject() {
        log();
    }

    private void log()
    {
        //调用方法的方法名
        String methodName=new Exception().getStackTrace()[1].getMethodName();
        String className=this.getClass().getName();
        String classInfo=this.toString();
        System.out.println(String.format("执行目标对象：%s（%s）的方法:%s",className,classInfo,methodName));
    }

    public static String getTraceInfo(){
        StringBuffer sb = new StringBuffer();

        StackTraceElement[] stacks = new Throwable().getStackTrace();
        int stacksLen = stacks.length;
        sb.append("class: " ).append(stacks[1].getClassName()).append("; method: ").append(stacks[1].getMethodName()).append("; number: ").append(stacks[1].getLineNumber());

        return sb.toString();
    }
}
