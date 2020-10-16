package com.cm.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class OrderDao {

    public void orderStr(String str) {
        System.out.println("order "+ str);
    }

}
