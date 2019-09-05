package com.ucar.training.service.impl;

import com.ucar.training.dao.GoodDao;
import com.ucar.training.entity.Goods;
import com.ucar.training.service.GoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service("goodService")
public class GoodServiceImp implements GoodService {
    @Resource
    private GoodDao goodDao;

    @Override
    public ArrayList<Goods> getAllGoods() {
        return goodDao.selectGoods();
    }

    @Override
    public ArrayList<Goods> selectGoodsByName(String keyName) {
        return goodDao.selectGoodsByName(keyName);
    }

    @Override
    public Goods getGood(int id) {
        return goodDao.selectGood(id);
    }

    @Override
    public void addGood(Goods good) {
        goodDao.insertGood(good);
    }

    @Override
    public void delGood(int id) {
        goodDao.delGood(id);
    }

    @Override
    public void modifyGood(Goods good) {
        goodDao.updateGood(good);
    }

    @Override
    public void modifyGoodsNum(int goodID, int goodNum) {
        goodDao.updateGoodsInventory(goodID,goodNum);
    }
}
