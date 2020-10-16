package com.cm.proxy;

import com.cm.dao.UserDao;

public class UserLog {//implements UserDao {

    private UserDao dao;

    public UserLog(UserDao dao) {
        this.dao = dao;
    }

    public void query() {
        System.out.println("__________log 聚合___________");
        dao.query();
    }

}
