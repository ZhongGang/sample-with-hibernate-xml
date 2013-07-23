package com.icode.spring;

import com.icode.core.model.Shop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-23
 * Time: 下午5:38
 */
public class ShopFactoryTest {

    @Test
    public void testGetObject() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:rootApplicationContext.xml");
        Shop shop1 = (Shop) context.getBean("shop");
        Shop shop2 = (Shop) context.getBean("shop");
        Shop shop3 = (Shop) context.getBean("shop");
        Shop shop4 = (Shop) context.getBean("shop");
        Shop shop5 = (Shop) context.getBean("shop");
        Assert.assertNotEquals(shop1.hashCode(), shop2.hashCode());

        ShopHolder shopHolder = context.getBean("shopHolder", ShopHolder.class);
        ShopContext shopContext = context.getBean("shopContext", ShopContext.class);
        Assert.assertNotEquals(shopHolder.getShop(), shopContext.getShop());
    }
}
