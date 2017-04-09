package daily.log.account;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class LogUtil
{
	Log log=LogFactory.getLog(LogUtil.class);
	
	private static float timeInterval=0;
	public void before()
	{
		timeInterval=new Date().getTime();
		log.error("\n begin:"+timeInterval);
	}
	
	public void after()
	{
		timeInterval=new Date().getTime()-timeInterval;
		log.error("\n after:"+timeInterval);
	}
}
