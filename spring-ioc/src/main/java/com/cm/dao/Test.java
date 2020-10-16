package com.cm.dao;

import com.cm.config.Spring;
import com.cm.service.IndexService1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
       /* ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");
        IndexService service = (IndexService) classPathXmlApplicationContext.getBean("service");
        service.service();*/

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Spring.class);
        System.out.println(annotationConfigApplicationContext.getBean(IndexService1.class).getClass().getSimpleName());
       /*IndexService service = (IndexService)annotationConfigApplicationContext.getBean("indexService1");
        service.service();
        IndexService serviceSing = (IndexService)annotationConfigApplicationContext.getBean("indexService");
        serviceSing.service();
        System.out.println(service.hashCode());
        System.out.println(serviceSing.hashCode());*/
    }

}
