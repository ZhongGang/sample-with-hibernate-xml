package com.icode.core.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-11
 * Time: 下午6:25
 */
@XmlRootElement
public class ShopOverviewDTOs {
    private List<ShopOverviewDTO> shopOverviewDTOs = new ArrayList<ShopOverviewDTO>();

    public ShopOverviewDTOs() {
    }

    public ShopOverviewDTOs(List<ShopOverviewDTO> shopOverviewDTOs) {
        this.shopOverviewDTOs = shopOverviewDTOs;
    }

    public List<ShopOverviewDTO> getShopOverviewDTOs() {
        return shopOverviewDTOs;
    }

    public void setShopOverviewDTOs(List<ShopOverviewDTO> shopOverviewDTOs) {
        this.shopOverviewDTOs = shopOverviewDTOs;
    }
}
