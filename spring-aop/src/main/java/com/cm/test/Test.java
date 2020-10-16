package com.cm.test;

import com.cm.app.AppConfig;
import com.cm.dao.Dao;
import com.cm.dao.IndexDao;
import com.cm.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                =new AnnotationConfigApplicationContext(AppConfig.class);
        //IndexDao dao = (IndexDao)annotationConfigApplicationContext.getBean(IndexDao.class);

   /*     Dao daoTest = (Dao) annotationConfigApplicationContext.getBean("orderDao");
        daoTest.query("TestDao");*/


       /* Dao dao = (Dao)annotationConfigApplicationContext.getBean("indexDao");
        Dao dao1 = (Dao)annotationConfigApplicationContext.getBean("indexDao");
        System.out.println(dao instanceof IndexDao);
        System.out.println(dao instanceof Dao);
        System.out.println(dao instanceof Proxy);
        dao.query("hello");
        dao1.query("world");

        System.out.println(dao.hashCode());
        System.out.println(dao1.hashCode());*/

        OrderDao dao = (OrderDao)annotationConfigApplicationContext.getBean("orderDao");
        OrderDao dao1 = (OrderDao)annotationConfigApplicationContext.getBean("orderDao");
     /*   System.out.println(dao instanceof IndexDao);
        System.out.println(dao instanceof Dao);
        System.out.println(dao instanceof Proxy);*/
        dao.orderStr("hello");
        dao1.orderStr("world");

        System.out.println(dao.hashCode());
        System.out.println(dao1.hashCode());

/*        Class<?>[] interfaces = new Class[]{Dao.class};

        byte[] cms = ProxyGenerator.generateProxyClass("Cm", interfaces);
        File file = new File("/Users/cm/Desktop/test.class");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(cms);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }

}
