package com.cm.dao;

public class UserDaoImpl implements UserDao{

    public void query () {
        System.out.println("假装查询数据库");
    }


    public void query(String string) {
        System.out.println("假装查询数据库:" + string);
    }

}
