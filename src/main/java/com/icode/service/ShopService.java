package com.icode.service;

import com.icode.core.dto.ExamineDTO;
import com.icode.core.dto.ShopFormDTO;
import com.icode.core.dto.ShopOverviewDTO;
import com.icode.core.model.CommentAttachment;
import com.icode.core.model.Shop;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-23
 * Time: 上午1:08
 */
public interface ShopService {

    String saveOrUpdateShop(ShopFormDTO shop);

    List<ShopOverviewDTO> loadShops();

    List search() throws InterruptedException;

    void saveOrUpdateExamine(ExamineDTO examine);

    List<ExamineDTO> loadExamines();

    void work();

    String saveShop(ShopFormDTO shopFormDTO);

    String updateShop(ShopFormDTO shopFormDTO);

    Shop loadShopByGuid(String guid);

    void saveOrUpdateAttachment(CommentAttachment attachment);
}
