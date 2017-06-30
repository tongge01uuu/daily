package com.springmvc.demo.quickstart;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * Created by yukai on 2017/6/26.
 */
public class MvcEntityVo {
    private int id;
    private String name;
    private List<String> hobby;
    private Map others;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String address;

    public MvcEntityVo() {
    }

    public MvcEntityVo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Map getOthers() {
        return others;
    }

    public void setOthers(Map others) {
        this.others = others;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
