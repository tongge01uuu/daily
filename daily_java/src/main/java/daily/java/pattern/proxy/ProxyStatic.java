package daily.java.pattern.proxy;

/**
 * Created by yukai on 2017/3/29.
 */
public class ProxyStatic {
    public static void main(String[] args) {

        SourceObjectService sourceObjectService=new SourceObjectServiceImpl();
        ProxyObject proxy=new ProxyObject(sourceObjectService);
        proxy.saveSourceObject();
        proxy.getSourceObject();
    }
}

class ProxyObject implements SourceObjectService
{
    private SourceObjectService sourceObjectService;
    public ProxyObject(SourceObjectService sourceObjectService)
    {
        this.sourceObjectService=sourceObjectService;
    }
    @Override
    public Object getSourceObject() {
        log();
        Object object=sourceObjectService.getSourceObject();
        return object;
    }

    @Override
    public void saveSourceObject() {
        log();
        sourceObjectService.saveSourceObject();
    }

    private void log()
    {
        //调用方法的方法名
        String methodName=new Exception().getStackTrace()[1].getMethodName();
        String className=this.getClass().getName();
        String classInfo=this.toString();
        System.out.println(String.format("执行静态代理对象：%s（%s）的方法:%s",className,classInfo,methodName));
    }
}


