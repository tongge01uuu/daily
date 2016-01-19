package local.test;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
//		Properties p=System.getProperties();
//		p.list(System.out);
		
		Map<String, Charset> map=Charset.availableCharsets();
		Set set=map.keySet();
		String key="";
		String value="";
		for(Iterator<String> it= set.iterator();it.hasNext();)
		{
			System.out.println(key=it.next()+" ---- "+Charset.isSupported(key));
			
		}
		
		
		
		
	}

}
