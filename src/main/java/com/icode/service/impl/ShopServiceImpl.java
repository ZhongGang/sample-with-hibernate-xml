package com.icode.service.impl;

import com.icode.core.dto.ExamineDTO;
import com.icode.core.dto.ShopFormDTO;
import com.icode.core.dto.ShopOverviewDTO;
import com.icode.core.model.Examine;
import com.icode.core.model.Shop;
import com.icode.dao.ShopDao;
import com.icode.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-23
 * Time: 上午1:08
 */
@Service("shopService")
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public void saveOrUpdateShop(ShopFormDTO shopFormDTO) {
        Shop shop = shopFormDTO.toShop();
        shopDao.saveOrUpdate(shop);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShopOverviewDTO> loadShops() {
        return shopDao.findShops();
    }

    @Override
    @Transactional(readOnly = true)
    public List search() throws InterruptedException {
        return shopDao.search();
    }

    @Override
    @Transactional
    public void saveOrUpdateExamine(ExamineDTO examineDTO) {
        Examine examine = examineDTO.toExamine();
        shopDao.saveOrUpdate(examine);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExamineDTO> loadExamines() {
        List<ExamineDTO> examineDTOs = new ArrayList<ExamineDTO>();
        List<Examine> examines = shopDao.findAll(Examine.class);
        for (Examine examine : examines) {
            ExamineDTO examineDTO = new ExamineDTO(examine);
            examineDTOs.add(examineDTO);
        }
        return examineDTOs;
    }
}
