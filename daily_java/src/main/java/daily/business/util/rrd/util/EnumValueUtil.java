/**
 * Copyright(c) 2010-2013 by Renrendai Inc.
 * All Rights Reserved
 */
package daily.business.util.rrd.util;

/**
 * 根据enum 值获取enum对象
 * 
 * @author jinkai
 */
public class EnumValueUtil {

    /**
     * 根据value获取enum对象
     * 
     * @return
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getEnumByValue(String value, Class<T> c) {
        if (!ValidateUtil.isEmpty(value)) {
            for (Object o : c.getEnumConstants()) {
                if (o.toString().equals(value)) {
                    return (T) o;
                }
            }
        }
        return null;
    }

    /**
     * 根据name获取enum对象
     *
     * @return
     * @return
     */
    public static <T> T getEnumByName(String name, Class<T> c) {
        if (!ValidateUtil.isEmpty(name)) {
            for (Object o : c.getEnumConstants()) {
                if (((Enum)o).name().toString().equals(name)) {
                    return (T) o;
                }
            }
        }
        return null;
    }

}
