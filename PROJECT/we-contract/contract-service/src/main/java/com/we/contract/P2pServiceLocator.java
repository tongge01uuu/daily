
package com.we.contract;

import com.site.spring.DefaultServiceLocator;
import org.springframework.context.ApplicationContext;


/**
 * @ClassName CurrentServiceLocator
 * @Date 2015年12月11日
 * @Description:
 */
public class P2pServiceLocator extends DefaultServiceLocator {

    /**
     * The context.
     */
    private static ApplicationContext context;

    static {
        try {
            context = getApplicationContext(P2pServiceLocator.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the context.
     *
     * @return the context
     */
    public static ApplicationContext getApplicationContext() {
        if (context == null) {
            throw new RuntimeException("Spring loading error!");
        }
        return context;
    }

}
