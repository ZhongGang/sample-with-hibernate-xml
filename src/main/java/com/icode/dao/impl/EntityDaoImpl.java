package com.icode.dao.impl;

import com.icode.core.model.AbstractEntity;
import com.icode.dao.EntityDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-23
 * Time: 上午1:32
 */
@Repository("entityDao")
public class EntityDaoImpl implements EntityDao {

    @Autowired
    protected SessionFactory sessionFactory;


    @Override
    public <T extends AbstractEntity> void saveOrUpdate(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(t);
    }

    @Override
    public <T extends AbstractEntity> T findByGuid(Class<T> clazz, String guid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from " + clazz.getSimpleName() + " c where c.guid=" + guid);
        return query.list().isEmpty() ? null : (T) query.list().get(0);
    }

    @Override
    public <T extends AbstractEntity> List<T> findAll(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from " + clazz.getSimpleName());
        return query.list();
    }
}
