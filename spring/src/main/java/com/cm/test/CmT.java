package com.cm.test;

import com.cm.service.UserService;
import org.spring.util.BeanFactory;

public class CmT {


        public static void main(String[] args) {

        BeanFactory beanFactory = new BeanFactory("spring.xml");

        UserService service = (UserService)beanFactory.getBean("service");
        //UserService service = new UserServiceImpl();
        service.find();
    }


}
