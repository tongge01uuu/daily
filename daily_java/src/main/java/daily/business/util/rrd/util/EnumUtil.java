/*
 * Copyright(c) 2007-2010 by Yingzhi Tech.
 * All Rights Reserved
 */
package daily.business.util.rrd.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ijay
 */
public class EnumUtil {

    private EnumUtil() {
    }

    public static <T extends Enum<T>> int encode(EnumSet<T> set) {
        if (set == null) {
            return 0;
        }

        int ret = 0;

        for (T val : set) {
            ret |= 1 << val.ordinal();
        }

        return ret;
    }

    public static <T extends Enum<T>> EnumSet<T> decode(Class<T> type, int code) {
        Map<Integer, T> codeMap = new HashMap<Integer, T>();

        for (T val : EnumSet.allOf(type)) {
            codeMap.put(val.ordinal(), val);
        }

        EnumSet<T> result = EnumSet.noneOf(type);
        while (code != 0) {
            int ordinal = Integer.numberOfTrailingZeros(code);
            code ^= Integer.lowestOneBit(code);
            result.add(codeMap.get(ordinal));
        }

        return result;
    }
}
