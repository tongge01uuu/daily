package daily.jave.se.map;

import java.util.*;

/**
 * Created by yukai on 2017/5/11.
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        testWeakHashMapAPIs();
        System.out.println(11 &  (21-1));
    }

    private static void testWeakHashMapAPIs() {
        // 初始化3个“弱键”
        String w1 = "one"; //实例在常量池中， w1指向null的时候 ， w1不会被回收
        String w2 = new String("two");
        String w3 = new String("three");
        // 新建WeakHashMap
        Map wmap = new WeakHashMap();
        // 添加键值对
        wmap.put(w1, "w1");
        wmap.put(w2, "w2");
        wmap.put(w3, "w3");
        // 打印出wmap
        System.out.printf("\nwmap:%s\n",wmap );
        // containsKey(Object key) :是否包含键key
        System.out.printf("contains key two : %s\n",wmap.containsKey("two"));
        System.out.printf("contains key five : %s\n",wmap.containsKey("five"));
        // containsValue(Object value) :是否包含值value
        System.out.printf("contains value 0 : %s\n",wmap.containsValue(new Integer(0)));
        // remove(Object key) ： 删除键key对应的键值对
        wmap.remove("three");
        System.out.printf("after remove three wmap: %s\n",wmap );
        // ---- 测试 WeakHashMap 的自动回收特性 ----
        // 将w1设置null。
        // 这意味着“弱键”w1再没有被其它对象引用，调用gc时会回收WeakHashMap中与“w1”对应的键值对
        w1 = null;
        // 内存回收。这里，会回收WeakHashMap中与“w1”对应的键值对
        System.gc();
        // 遍历WeakHashMap
        Iterator iter = wmap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry en = (Map.Entry)iter.next();
            System.out.printf("next : %s - %s\n",en.getKey(),en.getValue());
        }
        // 打印WeakHashMap的实际大小
        System.out.printf(" after gc WeakHashMap size:%s\n", wmap.size());
    }
}
class WeakHashMapTest {
    static Map weakHashMap = new WeakHashMap();
    static String key1=new String("1");
    static String key2="2";
    static{
        weakHashMap.put(key1, "ding");
        weakHashMap.put(key2, "job");
    }
    public static void testWeakHashMap(){
        System.out.println("first get:"+ weakHashMap.toString());
        try {
            key1=null;
            weakHashMap.size();
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.gc();
        System.out.println("next get:"+ weakHashMap.toString());
    }
    public static void main(String[] args) {
        testWeakHashMap();
    }
}

/*
 10  * @desc 遍历WeakHashMap的测试程序。
 11  *   (01) 通过entrySet()去遍历key、value，参考实现函数：-效率高
 12  *        iteratorHashMapByEntryset()
 13  *   (02) 通过keySet()去遍历key、value，参考实现函数：-效率低
 14  *        iteratorHashMapByKeyset()
 15  *   (03) 通过values()去遍历value，参考实现函数：
 16  *        iteratorHashMapJustValues()
 17  *
 18  * @author skywang
 19  */
class WeakHashMapIteratorTest {
    public static void main(String[] args) {
        int val = 0;
        String key = null;
        Integer value = null;
        Random r = new Random();
        WeakHashMap map = new WeakHashMap();
        for (int i=0; i<12; i++) {
            // 随机获取一个[0,100)之间的数字
            val = r.nextInt(100);
            key = String.valueOf(val);
            value = r.nextInt(5);
            // 添加到WeakHashMap中
            map.put(key, value);
            System.out.println(" key:"+key+" value:"+value);
        }
        // 通过entrySet()遍历WeakHashMap的key-value
        iteratorHashMapByEntryset(map) ;
        // 通过keySet()遍历WeakHashMap的key-value
        iteratorHashMapByKeyset(map) ;
        // 单单遍历WeakHashMap的value
        iteratorHashMapJustValues(map);
    }
    /*
  * 通过entry set遍历WeakHashMap
  * 效率高!
  */
         private static void iteratorHashMapByEntryset(WeakHashMap map) {
             if (map == null)
                     return ;

             System.out.println("\niterator WeakHashMap By entryset");
             String key = null;
             Integer integ = null;
             Iterator iter = map.entrySet().iterator();
             while(iter.hasNext()) {
                     Map.Entry entry = (Map.Entry)iter.next();

                     key = (String)entry.getKey();
                     integ = (Integer)entry.getValue();
                     System.out.println(key+" -- "+integ.intValue());
                 }
         }

     /*
    * 通过keyset来遍历WeakHashMap
    * 效率低!
    */
         private static void iteratorHashMapByKeyset(WeakHashMap map) {
         if (map == null)
                 return ;

         System.out.println("\niterator WeakHashMap By keyset");
         String key = null;
         Integer integ = null;
         Iterator iter = map.keySet().iterator();
         while (iter.hasNext()) {
                 key = (String)iter.next();
                 integ = (Integer)map.get(key);
                 System.out.println(key+" -- "+integ.intValue());
             }
     }


 /*
  * 遍历WeakHashMap的values
  */
        private static void iteratorHashMapJustValues(WeakHashMap map) {
        if (map == null)
                return ;

        Collection c = map.values();
        Iterator iter= c.iterator();
        while (iter.hasNext()) {
                 System.out.println(iter.next());
            }
     }
}