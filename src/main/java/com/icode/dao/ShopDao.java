package com.icode.dao;

import com.icode.core.dto.ShopOverviewDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-23
 * Time: 上午1:08
 */
public interface ShopDao extends EntityDao {

    List<ShopOverviewDTO> findShops();

    List search() throws InterruptedException;
}
