package com.icode.spring;

import com.icode.core.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-23
 * Time: 下午5:38
 */
@ContextConfiguration(value = "classpath:rootApplicationContext.xml")
public class ShopFactoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private Shop shop;

    @Test
    public void testGetObject() throws Exception {
        System.out.print(shop);
    }
}
