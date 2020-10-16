package com.cm.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;


//@Component("dao")
@Repository("myIndexDao")
//@Scope("prototype")
//public class IndexDaoImpl implements IndexDao, InitializingBean, DisposableBean {
public class IndexDaoImpl implements IndexDao {
    @Override
    public void test() {
        System.out.println("impl");
    }

    public IndexDaoImpl () {
        System.out.println("构造器");
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

   /* @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }*/
}
