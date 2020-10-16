package com.cm.test;

import com.cm.entity.CityEntity;
import com.cm.utils.CommonUtils;

public class Test {

    public static void main(String[] args) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId("1");
        cityEntity.setName("test");
        String sql = CommonUtils.buildQuerySqlForEntity(cityEntity);
        System.out.println(sql);
    }

}
