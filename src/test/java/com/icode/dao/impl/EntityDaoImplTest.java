package com.icode.dao.impl;

import com.icode.core.model.Product;
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
    public void testSaveOrUpdate() throws Exception {
        for (int i = 0; i < 100000; i++) {
            Shop shop = new Shop("Shop" + i, "Shop" + i);
            Session session = sessionFactory.getCurrentSession();
            session.persist(shop);
        }
    }

    @Test
    @Transactional
    public void testNPlusOneProblem() throws Exception {
        Session session = sessionFactory.openSession();

        Shop shop1 = new Shop();
        shop1.add(new Product());
        shop1.add(new Product());
        session.saveOrUpdate(shop1);

        Shop shop2 = new Shop();
        shop2.add(new Product());
        shop2.add(new Product());
        shop2.add(new Product());
        session.saveOrUpdate(shop2);

        Shop shop3 = new Shop();
        shop3.add(new Product());
        shop3.add(new Product());
        shop3.add(new Product());
        shop3.add(new Product());
        session.saveOrUpdate(shop3);

        session.flush();
        session.clear();

        session.createCriteria(Shop.class).list();
    }
}
