package com.cm.utils;

import com.cm.anno.Entity;

public class CommonUtils {

    /**
     * 通过对象构建查询sql
     * @param object
     */
    public static String buildQuerySqlForEntity(Object object) {

        Class clazz = object.getClass();
        /*判断是否加了注解*/
        if (clazz.isAnnotationPresent(Entity.class)) {
            /*得到注解的值*/
            Entity entity = (Entity)clazz.getAnnotation(Entity.class);
            /*调用方法*/
            String entityName = entity.value();
            System.out.println(entityName);
        }
        String sql = "select * from ";

        return "";
    }

}
