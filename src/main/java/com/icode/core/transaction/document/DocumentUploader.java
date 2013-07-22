package com.icode.core.transaction.document;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-22
 * Time: 上午11:20
 */
public interface DocumentUploader {

    String upload();

    void commit();

    void rollback();
}
