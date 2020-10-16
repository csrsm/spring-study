package com.cm.proxyExtends;

import com.cm.dao.UserDaoImpl;

public class UserDaoPower extends UserDaoImpl {

    @Override
    public void query() {
        System.out.println("———————————————————power 继承———————————————————");
        super.query();
    }
}
