package daily.jave.se.directMemory;

import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.file.WatchEvent;

/**
 * Created by yukai on 2017/3/20.
 */
public class DirectMemoryDemo {
    public static void main(String[] args) throws Exception{
        unsafeTest();
        byteBufferTest();
    }

    public static void byteBufferTest()
    {
        int i=0;
        ByteBuffer byteBuffer=null;
        while (true)
        {
            System.out.println(i++);
            //分配直接内存（堆外内存）
            byteBuffer=ByteBuffer.allocateDirect(10*1024*1024);

            /*
             -verbose:gc
             -XX:+PrintGCDetails
             -XX:+DisableExplicitGC  #禁用代码中显式调用GC System.gc()
             -XX:MaxDirectMemorySize=40M
             */
            /*
             设置以上JVM参数 运行模拟堆外内存溢出,从日志可以看出,
             堆内存（包括新生代和老年代）内存很充足,但是内存溢出了
             可见NIO直接内存的回收，需要依赖于System.gc()
            */
        }
    }
    public static void unsafeTest()throws Exception
    {
        Unsafe unsafe=getUnsafeInstance();
        unsafe.allocateMemory(400*1024*1024);
        Field[] fields=DirectMemoryVo.class.getDeclaredFields();
        System.out.println(fields.length);
        for(Field field:fields)
        {
            field.setAccessible(true);
            if (!Modifier.isStatic(field.getModifiers()))
            {
                //非静态变量/成员变量
                System.out.println(unsafe.objectFieldOffset(DirectMemoryVo.class.getDeclaredField(field.getName())));
            }else {
                //非静态变量/成员变量
                System.out.println(unsafe.staticFieldOffset(DirectMemoryVo.class.getDeclaredField(field.getName())));
            }
        }
    }
    public static Unsafe getUnsafeInstance() throws Exception
    {
        // 通过反射获取rt.jar下的Unsafe类
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        // return (Unsafe) theUnsafeInstance.get(null);是等价的
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
}

class DirectMemoryVo
{
    private int intVal;
    static int intValStatic;
    public String str;
    static String strStatic;
}