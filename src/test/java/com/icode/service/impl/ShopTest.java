package com.icode.service.impl;

import com.icode.core.dto.ShopFormDTO;
import com.icode.core.model.Shop;
import com.icode.service.ShopService;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-23
 * Time: 下午12:42
 */
@ContextConfiguration(locations = "classpath:rootApplicationContext.xml")
public class ShopTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ShopService shopService;

    @Test
    @Transactional(propagation = Propagation.SUPPORTS)
    public void testSaveOrUpdateShopWithoutTransaction() throws Exception {
        Shop shop = new Shop();
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(shop);

        session.flush();
        session.clear();

        shop = (Shop) session.get(Shop.class, 1, LockOptions.UPGRADE);
        Assert.assertEquals(shop, shop);
    }

    @Test
    public void testSaveOrUpdateShopWithTransaction() throws Exception {
        ShopFormDTO shopFormDTO = new ShopFormDTO();
        shopService.saveOrUpdateShop(shopFormDTO);

        TransactionSynchronizationManager.isActualTransactionActive();
    }
}
