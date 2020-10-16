package com.cm.dao;

public abstract class TestAbstract {

    private String test;

    private String name;

    public void test() {
        System.out.println("testAbstract");
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
