package com.cm.proxyExtends;

import com.cm.dao.UserDaoImpl;

public class UserDaoTime extends UserDaoImpl {

    @Override
    public void query() {
        System.out.println("———————————————————time 继承———————————————————");
        super.query();
    }
}
