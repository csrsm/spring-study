package com.cm.proxyExtends;

import com.cm.dao.UserDaoImpl;

public class UserDaoLog extends UserDaoImpl {

    @Override
    public void query() {
        System.out.println("———————————————————log 继承———————————————————");
        super.query();
    }
}
