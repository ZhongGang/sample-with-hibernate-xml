package com.icode.spring;

import com.icode.core.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-23
 * Time: 下午6:15
 */
@Component("shopHolder")
public class ShopHolder {

    @Autowired
    private Shop shop;

    public Shop getShop() {
        return shop;
    }
}
