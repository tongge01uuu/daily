package daily.spring.aspect.xml;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by phantom on 2017/4/6.
 */
public class PlusBusinessImpl implements PlusBusiness {
    private static final Logger logger= LoggerFactory.getLogger(PlusBusinessImpl.class);

    public void doBusinessPlus()
    {
        log();
        logger.info(" doBusinessPlus execution ");
    }

    public void doBusinessPlus(int param)
    {
        logger.info(param+" doBusinessPlus with param execution");
    }
    private void log()
    {
        //调用方法的方法名
        String methodName=new Exception().getStackTrace()[1].getMethodName();
        String className=this.getClass().getSimpleName();
        String classInfo=this.toString();
        logger.info(String.format("执行对象：%s（%s）的方法:%s",className,classInfo,methodName));
    }
}
