package com.icode.core.job;

import com.icode.core.model.Shop;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-30
 * Time: 下午11:55
 */
public class ShopItemProcessor implements ItemProcessor<Shop, Shop> {

    @Override
    public Shop process(Shop item) throws Exception {
        item.description();
        return item;
    }
}
