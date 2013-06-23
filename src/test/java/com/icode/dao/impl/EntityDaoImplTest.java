package com.icode.dao.impl;

import com.icode.core.model.Shop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-23
 * Time: 下午1:41
 */
@ContextConfiguration(locations = "classpath:rootApplicationContext.xml")
public class EntityDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testSaveOrUpdate() throws Exception {
        Shop shop = new Shop("Shop1", "Shop111111111");
        Session session = sessionFactory.getCurrentSession();
        session.persist(shop);
    }
}
