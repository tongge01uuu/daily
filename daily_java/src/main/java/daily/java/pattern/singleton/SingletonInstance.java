package daily.java.pattern.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yukai on 2017/4/28.
 */
public class SingletonInstance {
    public static void main(String[] args) {
        System.out.println(SingletonHungary.getInstance());
        System.out.println(SingletonLazy.getInstance());
        System.out.println(SingletonDCL.getInstance());
        System.out.println(SingletonStatic.getInstance());
        SingletonInstance singletonInstance=new SingletonInstance();
        String key=SingletonInstance.class.getSimpleName();
        SingletonContainer.addInstance(key,singletonInstance);
        System.out.println(SingletonContainer.getInstance(key));
    }
}

/**
 * 1-饿汉式
 */
class SingletonHungary
{
    private static SingletonHungary singletonHungary=new SingletonHungary();
    private SingletonHungary(){}
    public static SingletonHungary getInstance(){
        return singletonHungary;
    }
}

/**
 * 2-懒汉式
 */
class SingletonLazy
{
    private static SingletonLazy singletonLazy;
    private SingletonLazy(){};
    //此处可加入synchronized来防止并发，但效率低，参照DCL优化
    public static SingletonLazy getInstance()
    {
        if (singletonLazy==null)
        {
            singletonLazy=new SingletonLazy();
        }
        return singletonLazy;
    }
}

/**
 * 3-Double Check Lock (DCL) 实现单例
 *  同步加锁懒汉式地一种优化,
 *  由于Java内存模型的原因偶尔会失败，在高并发情况下或低于JDK 6版本下使用可能出现DCL失效问题，虽然概率很小
 *
 */
class SingletonDCL{
    private static SingletonDCL singletonDCL;
    private SingletonDCL(){};
    final static Lock lock=new ReentrantLock();
    //此处可加入synchronized来防止并发，但效率低，参照DCL优化
    public static SingletonDCL getInstance()
    {
        if (singletonDCL ==null)
        synchronized (SingletonDCL.class){
            if (singletonDCL ==null)
            {
                singletonDCL =new SingletonDCL();
            }
        }
        return singletonDCL;

        /**
         * 实现方式-2
         * 首先要操作ReentrantLock的加锁（lock）和解锁（unlock）必须是针对同一个ReentrantLock对象，
         * 要是new 两个ReetrantLock来分别完成对同一资源的加锁和解锁是没有意义的。
         */

//        lock.lock();
//        try {
//            if (singletonDCL ==null)
//            {
//                singletonDCL =new SingletonDCL();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//        return singletonDCL;

    }
}

/**
 * 4-静态内部类
 *  主要利用了final关键字的特性
 */
class SingletonStatic
{
    private SingletonStatic(){}
    public static SingletonStatic getInstance()
    {
        return SingletonHolder.singletonStatic;
    }
    private static class SingletonHolder{
        private static final SingletonStatic singletonStatic=new SingletonStatic();
    }
}

/**
 * 5-枚举单例
 */
enum SingletonEnum
{
    INSTANCE;
    private String field1;
    private String field2;
}

/**
 * 容器实现单例
 */
class SingletonContainer
{
    private static Map<String,Object> container=new ConcurrentHashMap();

    /**
     * 往容器添加任意类别的单例
     * @param instanceKey 容器key 不同类型的区分 例如：可以用类的名字当做此key
     * @param instance 容器value 不同类的实例 可以直接new一个
     * example addInstance("Student",new Student());
     */
    public static void addInstance(String instanceKey,Object instance)
    {
        if (!container.containsKey(instanceKey))
        {
            container.put(instanceKey,instance);
        }else {
            throw new RuntimeException(String.format("key:%s 的实例已经生成 ",instanceKey));
        }
    }

    public static Object getInstance(String instanceKey)
    {
        return container.get(instanceKey);
    }
}