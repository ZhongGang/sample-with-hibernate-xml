package com.icode.service.impl;

import com.icode.core.model.Shop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-23
 * Time: 下午12:42
 */
@ContextConfiguration(locations = "classpath:rootApplicationContext.xml")
public class ShopTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void testSaveOrUpdateShopWithoutTransaction() throws Exception {
        Shop shop = new Shop();
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(shop);
    }
}
