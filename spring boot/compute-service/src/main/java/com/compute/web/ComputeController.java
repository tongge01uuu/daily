package com.compute.web;

import com.compute.vo.ComputeVo;
import com.fasterxml.jackson.core.JsonParser;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @ApiOperation(value="获取用加法结果", notes="根据入参a，b获取他们的和")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", value = "参数a", required = true,paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "b", value = "参数b", required = true, paramType = "query",dataType = "Integer")
    })
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

    /*
    paramType Valid values are {@code path}, {@code query}, {@code body}, {@code header} or {@code form}.
     */
    @ApiOperation(value="获取compute对象", notes="根据入参获取compute")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "参数id", required = true, paramType = "path",dataType = "Integer"),
            @ApiImplicitParam(name = "computeVoParam", value = "参数ComputeVo", required = true,paramType = "body",dataType = "ComputeVo")
    })
    @RequestMapping(value = "/add/{id}" ,method = RequestMethod.POST)
    public ComputeVo get(@PathVariable Integer id,@RequestBody ComputeVo computeVoParam)
    {
        ComputeVo computeVo=new ComputeVo();
        logger.info("获取id为"+id+"的实体");
        computeVo.setId(id);
        computeVo.setA(computeVoParam.getA());
        computeVo.setB(computeVoParam.getB());
        return computeVo;
    }
}