package com.icode.service.impl;

import com.icode.core.dto.ExamineDTO;
import com.icode.core.dto.ShopFormDTO;
import com.icode.core.dto.ShopOverviewDTO;
import com.icode.core.model.CommentAttachment;
import com.icode.core.model.Examine;
import com.icode.core.model.Shop;
import com.icode.core.transaction.Worker;
import com.icode.core.transaction.WorkerFactory;
import com.icode.dao.ShopDao;
import com.icode.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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

    @Autowired
    private WorkerFactory workerFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String saveOrUpdateShop(ShopFormDTO shopFormDTO) {
        if (shopFormDTO.isNew()) {
            return saveShop(shopFormDTO);
        } else {
            return updateShop(shopFormDTO);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<ShopOverviewDTO> loadShops() {
        return shopDao.findShops();
    }

    @Override
    @Transactional(readOnly = true)
    public List search() throws InterruptedException {
        return shopDao.search();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
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

    @Override
    @Transactional
    public void work() {
        Shop shop = new Shop();
        shopDao.saveOrUpdate(shop);
        Worker worker = workerFactory.create();
        worker.work(30);
//        throw new UnsupportedOperationException("Check whether the worker is committed or rollback~~~");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
    public String saveShop(ShopFormDTO shopFormDTO) {
        Shop shop = shopFormDTO.toShop();
        shopDao.saveOrUpdate(shop);
        return shop.getGuid();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public String updateShop(ShopFormDTO shopFormDTO) {
        Shop shop = shopFormDTO.toShop();
        shopDao.saveOrUpdate(shop);
        return shop.getGuid();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public Shop loadShopByGuid(String guid) {
        return shopDao.findByGuid(Shop.class, guid);
    }

    @Override
    public void saveOrUpdateAttachment(CommentAttachment attachment) {
        shopDao.saveOrUpdate(attachment);
    }

    @Override
    public CommentAttachment loadCommentAttachment(String guid) {
        return shopDao.findByGuid(CommentAttachment.class, guid);
    }
}
