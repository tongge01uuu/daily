package com.we.contract.util;

import com.site.bean.resultBean.Result;

/**
 * Created by yukai on 2017-9-12.
 */
public class ResultUtil {

    public static boolean isNull(Result param)
    {
        boolean result=false;
        if (param==null)
        {
            result=true;
        }else if (param.getValue()==null)
        {
            result=true;
        }
        return result;
    }
}
