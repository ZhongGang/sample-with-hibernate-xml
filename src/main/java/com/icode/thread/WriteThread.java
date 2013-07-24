package com.icode.thread;

import com.icode.core.dto.ShopFormDTO;
import com.icode.core.model.Shop;
import com.icode.service.ShopService;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-24
 * Time: 上午12:02
 */
public class WriteThread extends Thread {

    private ShopService shopService;

    public WriteThread(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void run() {
        Shop shop = shopService.loadShopByGuid("11");
        ShopFormDTO shopFormDTO = new ShopFormDTO(shop);
        System.out.println("Begin to run write thread~~~");
        shopService.saveOrUpdateShop(shopFormDTO);
        System.out.println("End to run write thread~~~");
    }
}
