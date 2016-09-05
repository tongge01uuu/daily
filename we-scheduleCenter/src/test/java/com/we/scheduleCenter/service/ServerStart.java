package com.we.scheduleCenter.service;

import org.junit.Test;

import com.we.scheduleCenter.base.BaseTest;

public class ServerStart extends BaseTest {

    @Test
    public void test() {
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
