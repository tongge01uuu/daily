package com.we.p2p.service;

import com.site.bean.resultBean.Result;

public interface DemoService {
    /**
     * demo
     * 1、rely接口都要加注释，实现类可以不写注释
     * 2、用到的状态相关的请定义enum（enums包下）
     * 3、参数较多情况下，请封装到vo里（超过4个建议封装vo）
     * 4、返回类型统一为Result类型,通过泛型处理具体返回值：Result<List<BankSupportVo>> ，Result<String> 等等
     * @return
     */
    public Result<String> demo();

}
