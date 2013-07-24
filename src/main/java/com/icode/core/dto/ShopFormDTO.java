package com.icode.core.dto;

import com.icode.core.model.Shop;
import com.icode.dao.ShopDao;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-22
 * Time: 下午11:11
 */
@Configurable(autowire = Autowire.BY_NAME, preConstruction = true)
public class ShopFormDTO {
    private String guid;
    private String name;
    private String description;

    @Autowired
    private ShopDao shopDao;

    public ShopFormDTO() {
    }

    public ShopFormDTO(Shop shop) {
        this.guid = shop.getGuid();
        this.name = shop.getName();
        this.description = shop.getDescription();
    }

    public ShopFormDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public boolean isNew() {
        return this.guid == null || this.guid.trim().equals("");
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Shop toShop(ShopDao shopDao) {
        if (isNew()) {
            return new Shop(this.name, this.description);
        } else {
            Shop shop = shopDao.findByGuid(Shop.class, this.guid);
            shop.update(this.name, this.description);
            return shop;
        }
    }
}
