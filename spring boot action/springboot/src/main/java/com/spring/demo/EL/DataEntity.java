package com.spring.demo.EL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yukai on 2017/6/19.
 */
@Component
public class DataEntity {
    @Value("其他类的属性")
    private String otherProperty;

    public String getOtherProperty() {
        return otherProperty;
    }

    public void setOtherProperty(String otherProperty) {
        this.otherProperty = otherProperty;
    }
}
