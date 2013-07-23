package com.icode.spring;

import com.icode.core.model.Shop;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-23
 * Time: 下午5:36
 */
@Component("shop")
public class ShopFactory implements FactoryBean<Shop> {

    @Override
    public Shop getObject() throws Exception {
        return new Shop();
    }

    @Override
    public Class<?> getObjectType() {
        return Shop.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
