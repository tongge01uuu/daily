package com.springboot.configurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yukai on 2017/6/29.
 */
@RestController
public class DBController {

    @Autowired
    private DBSetting dbSetting;

    @RequestMapping("/db")
    public DBSetting getDBSetting()
    {
        return dbSetting;

    }
}
