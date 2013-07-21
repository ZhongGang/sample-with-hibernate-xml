package com.icode.core.transaction;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-21
 * Time: 下午9:38
 */
public interface Worker {

    void work(int value);

    void commit();

    void rollback();
}
