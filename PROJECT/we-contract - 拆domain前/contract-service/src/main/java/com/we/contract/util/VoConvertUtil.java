package com.we.contract.util;

import com.we.contract.entity.Demo;
import com.we.contract.vo.DemoVo;
import org.springframework.beans.BeanUtils;

/**
 * User:hgq
 * Datetime:2016/5/8 20:51
 */
public class VoConvertUtil {


    public static DemoVo convertDemo(Demo p) throws Exception {
        DemoVo vo = new DemoVo();
        BeanUtils.copyProperties(p, vo);
        return vo;
    }
}
