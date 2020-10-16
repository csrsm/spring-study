package com.cm.test;

import com.cm.dao.*;
import com.cm.proxy.CmInvocationHandlerImpl;
import com.cm.proxy.ProxyUtils;
import com.cm.proxy.UserLog;
import com.cm.proxyExtends.UserDaoLog;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        //静态代理
        /*UserDao dao1 = new UserDaoImpl();
        UserDao dao = new UserLog(dao1);
        dao.query();

        UserDao dao2 = new UserDaoLog();
        dao2.query();*/

        //自定义动态代理
        /*UserDao proxy = (UserDao)ProxyUtils.newIntance(new UserDaoImpl());
        proxy.query();
        proxy.query("Hello World");*/
        /*Long a = System.currentTimeMillis();
        CmDao cmDao = (CmDao)ProxyUtils.newIntance(new CmDaoImpl(), new CmInvocationHandlerImpl());
        try {
            System.out.println(cmDao.query());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - a);*/

        //jdk动态代理
//        Long a = System.currentTimeMillis();
////        CmDao jdkProxy = (CmDao) Proxy.newProxyInstance(Test.class.getClassLoader(),
////                new Class[]{CmDao.class}, new InvocationHandlerUtils(new CmDaoImpl()));
////        try {
////            jdkProxy.query();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        System.out.println(System.currentTimeMillis() - a);
        TestAbstract testAbstract = new TestAbstract() {
            @Override
            public void test() {
                super.test();
            }
        };

        TestAbstractImpl testAbstract1 = new TestAbstractImpl();
        testAbstract1.test111();

    }

}
