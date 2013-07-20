package com.icode.hibernate;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-20
 * Time: 下午5:48
 */
public class MySQL5InnoDBCharsetDialect extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        String tableTypeString = super.getTableTypeString();
        return tableTypeString + " DEFAULT CHARSET=utf8;";
    }
}
