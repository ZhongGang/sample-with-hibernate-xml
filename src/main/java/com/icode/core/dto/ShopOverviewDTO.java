package com.icode.core.dto;

import com.icode.core.model.Shop;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-30
 * Time: 下午2:19
 */
public class ShopOverviewDTO {
    private String guid;
    private String name;
    private String description;

    public ShopOverviewDTO(Shop shop) {
        this.guid = shop.getGuid();
        this.name = shop.getName();
        this.description = shop.getDescription();
    }

    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
