package com.cm.dao;

import com.cm.anno.Cm;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("prototype")
@Transactional
public class IndexDao implements Dao{

    @Cm
    public void query(String string) {
        System.out.println("query："+string);
    }

}
