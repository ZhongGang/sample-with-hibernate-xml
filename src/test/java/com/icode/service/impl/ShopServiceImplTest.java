package com.icode.service.impl;

import com.icode.core.dto.ShopFormDTO;
import com.icode.service.ShopService;
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
}
