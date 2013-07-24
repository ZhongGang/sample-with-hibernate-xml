package com.icode.thread;

import com.icode.core.dto.ShopOverviewDTO;
import com.icode.service.ShopService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-24
 * Time: 上午12:11
 */
public class ReadThread extends Thread {

    private ShopService shopService;

    public ReadThread(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void run() {
        List<ShopOverviewDTO> shopOverviewDTOs = shopService.loadShops();
        System.out.println("Thread named " + Thread.currentThread().getName() + ": the size of shops is " + shopOverviewDTOs.size());
    }
}
