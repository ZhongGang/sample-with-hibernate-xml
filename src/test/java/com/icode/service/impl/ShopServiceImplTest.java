package com.icode.service.impl;

import com.icode.core.dto.ShopFormDTO;
import com.icode.service.ShopService;
import com.icode.thread.ReadThread;
import com.icode.thread.WriteThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-20
 * Time: 下午11:43
 */
@ContextConfiguration(locations = "classpath:rootApplicationContext.xml")
public class ShopServiceImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private ShopService shopService;

    @Test
    @Transactional(readOnly = true)
    public void testSaveOrUpdateShop() throws Exception {
        ShopFormDTO shop = new ShopFormDTO();
        shop.setName("SHOP_SHOP_SHOP");
        shopService.saveOrUpdateShop(shop);
    }

    @Test
    @Rollback(value = false)
    public void testWork() throws Exception {
        shopService.work();
    }

    @Test
    @Transactional
    public void testSaveOrUpdateShopWithDifferentTransaction() throws Exception {
        WriteThread writeThread = new WriteThread(shopService);
        writeThread.start();

        for (int i = 0; i < 10; i++) {
            ReadThread readThread = new ReadThread(shopService);
            readThread.start();
        }


        Thread.sleep(10000);
    }
}
