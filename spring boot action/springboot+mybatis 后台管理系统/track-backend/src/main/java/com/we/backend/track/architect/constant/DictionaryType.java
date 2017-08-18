package com.we.backend.track.architect.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yukai on 2017-8-16.
 */
public class DictionaryType {
    //0-流程节点
    public static final int USER_FLOW_TITLE=0;

    public final static List<Integer> allTypes()
    {
        List result = new ArrayList();
        result.add(USER_FLOW_TITLE);
        return result;
    }

}
