package com.we.p2p.util;

import com.we.p2p.entity.Demo;
import com.we.p2p.vo.DemoVo;
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
