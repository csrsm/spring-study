package com.cm.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexService implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    //@Autowired
    @Resource(name = "myIndexDao")
    private IndexDao dao;

    /*public IndexService(IndexDao dao){
        this.dao = dao;
    }*/

    public void service(){
        applicationContext.getBean("myIndexDao");
        dao.test();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

/*    public void setDao(IndexDao dao) {
        this.dao = dao;
    }*/

}
