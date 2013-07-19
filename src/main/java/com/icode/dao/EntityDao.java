package com.icode.dao;

import com.icode.core.model.AbstractEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-23
 * Time: 上午1:32
 */
public interface EntityDao {

    <T extends AbstractEntity> void saveOrUpdate(T t);

    <T extends AbstractEntity> T findByGuid(Class<T> clazz, String guid);

    <T extends AbstractEntity> List<T> findAll(Class<T> clazz);
}
