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
        System.out.println("-----------------------");
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

        System.out.println("获取操作系统位数");
        //  返回4或8,代表是32位还是64位操作系统。
        System.out.println(unsafe.addressSize());
        // 返回32或64,获取操作系统是32位还是64位
        System.out.println(System.getProperty("sun.arch.data.model"));
        System.out.println("获取内存地址变量偏移");
        Field[] fields=DirectMemoryVo.class.getDeclaredFields(); //此处注意与getFields的区别
        System.out.println(fields.length);
        String fieldName="";
        String fieldType="";
        long instanceOffset=0;
        long staticOffset=0;
        long base=0;
        DirectMemoryVo directMemoryVo=new DirectMemoryVo(99,"unsafe");
        directMemoryVo.setIntValStatic(1000);
        directMemoryVo.setStrStatic("static unsafe");
        for(Field field:fields)
        {
            field.setAccessible(true);
            if (!Modifier.isStatic(field.getModifiers()))
            {
                fieldName=field.getName();
                fieldType=field.getType().getName();
                //DirectMemoryVo.class.getDeclaredField(fieldName)
                instanceOffset=unsafe.objectFieldOffset(field);
                //非静态变量/成员变量
                Object obj=unsafe.getObject(directMemoryVo,instanceOffset);
                System.out.println(String.format("实例变量:%s 内存偏移量：%d 值：%s",fieldName,instanceOffset,fieldType.equals("int")?Integer.parseInt(String.valueOf(obj)):obj));
            }else {
                //非静态变量/成员变量
                System.out.println(unsafe.staticFieldOffset(DirectMemoryVo.class.getDeclaredField(field.getName())));
            }
        }

//        System.out.println("获取实例变量的值");


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
    private static int intValStatic;
    public String str;
    private static String strStatic;
    public DirectMemoryVo(int intVal,String str)
    {
        this.intVal=intVal;
        this.str=str;
    }

    public static String getStrStatic() {
        return strStatic;
    }

    public static void setStrStatic(String strStatic) {
        DirectMemoryVo.strStatic = strStatic;
    }

    public static int getIntValStatic() {
        return intValStatic;
    }

    public static void setIntValStatic(int intValStatic) {
        DirectMemoryVo.intValStatic = intValStatic;
    }
}