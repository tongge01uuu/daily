package daily.java.pattern.factory;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by yukai on 2017/4/14.
 */
public class AdapterPatternInstance {
    Enumeration enumeration=new Enumeration() {
        @Override
        public boolean hasMoreElements() {
            return false;
        }

        @Override
        public Object nextElement() {
            return null;
        }
    };

    Iterator iterator=new Iterator() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    };
    /**场景描述：
     * JDK 1.1 Enumeration用来迭代元素
     * JDK 1.2 出现Iterator
     * 如何在升级JDK1.2之后，
     * 原1.1工程里用到Enumeration的地方能不出现异常
     * 并且能应用新功能Iterator
     *
     */

}
