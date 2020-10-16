package com.cm.app;

import com.cm.dao.Dao;
import com.cm.dao.IndexDao;
import com.cm.dao.OrderDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@Aspect("perthis(target(com.cm.dao.Dao))")
@Scope("prototype")
public class CmAspect {


    /*@DeclareParents(value="com.cm.dao.*+", defaultImpl= IndexDao.class)
    public static Dao dao;*/

    @Pointcut(value = "execution(void com.cm.dao.*.*(..))")
    public void executionPointCut() {

    }

    @Pointcut(value = " within(com.cm.dao.*)")
    public void withinPoinCut() {

    }

    @Pointcut(value = "args(java.lang.String)")
    public void argsPointCut() {

    }

    @Pointcut(value = " @annotation(com.cm.anno.Cm)")
    public void annoPointCut() {

    }

    @Pointcut(value = "this(com.cm.dao.IndexDao)")
    public void thisPointCut() {

    }

    @Pointcut(value = "target(com.cm.dao.IndexDao)")
    public void targetPointCut() {

    }

    @Pointcut(value = "target(com.cm.dao.IndexDao)")
    public void aroundPointCut() throws Throwable {

    }


    @Pointcut(value = "target(com.cm.dao.OrderDao)")
    public void aroundPointCutOrder() throws Throwable {

    }

    /*** Advice 通知***/
    @Before("withinPoinCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("advice before");
        //System.out.println(joinPoint.getThis());
        //System.out.println(joinPoint.getTarget());
    }

    /*** Advice 通知***/
    @After("executionPointCut()")
    public void after() {
        System.out.println("advice after");
    }

    /*** Advice 通知***/
    @Around("aroundPointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("advice around before");
        System.out.println(this.hashCode());
        Object[] args = pjp.getArgs();
        if (!ObjectUtils.isEmpty(args)) {
            for (int i = 0; i < args.length; i++) {
                args[i] += " world";
            }
        }
        pjp.proceed(args);
        System.out.println("advice around after");
    }


    /*** Advice 通知***/
    @Around("aroundPointCutOrder()")
    public void aroundOrder(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("order advice around before");
        System.out.println(this.hashCode());
        Object[] args = pjp.getArgs();
        if (!ObjectUtils.isEmpty(args)) {
            for (int i = 0; i < args.length; i++) {
                args[i] += " order";
            }
        }
        pjp.proceed(args);
        System.out.println("order advice around after");
    }


 /*   *//*** Advice 通知***//*
    @After("argsPointCut()")
    public void args() {
        System.out.println("advice args");
    }

    *//*** Advice 通知***//*
    @After("annoPointCut()")
    public void anno() {
        System.out.println("advice anno");
    }

    *//*** Advice 通知***//*
    @After("thisPointCut()")
    public void thisA() {
        System.out.println("advice this");
    }

    *//*** Advice 通知***//*
    @After("targetPointCut()")
    public void target() {
        System.out.println("advice target");
    }*/

}
