package com.we.contract.enums;

/**
 * Created by hgq on 2016/9/29.
 */
public enum DemoStatus {

    WAIT(0, "待处理"),
    PROCESS(1, "处理中"),
    SUCCESS(2, "成功"),
    FAIL(3, "失败");

    private String name;

    private int value;

    private DemoStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static String getName(int value) {
        for (DemoStatus item : DemoStatus.values()) {
            if (item.value == value) {
                return item.name;
            }
        }
        return null;
    }

    public static DemoStatus getInstance(int value) {
        for (DemoStatus item : DemoStatus.values()) {
            if (item.value == value) {
                return item;
            }
        }
        return null;
    }
}
