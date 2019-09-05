package com.ucar.training.service.impl;

import com.ucar.training.dao.CartGoodsDao;
import com.ucar.training.entity.CartGoods;
import com.ucar.training.service.CartGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class CartGoodsServiceImp implements CartGoodsService {
    @Resource
    private CartGoodsDao cartGoodsDao;

    @Override
    public ArrayList<CartGoods> getAllCartGoods(String username) {
        return cartGoodsDao.selectAll(username);
    }

    @Override
    public void delAllCartGoods(String username) {
        cartGoodsDao.delAllCartGoods(username);
    }

    @Override
    public void
    delCartGoods(int goodID,String username) {
        cartGoodsDao.delCartGoods(goodID,username);
    }

    @Override
    public void modifyGoodNum(int goodID,int goodNum,String username) {
        cartGoodsDao.updateCartGoods(goodID,goodNum,username);
    }

    @Override
    public Integer getCartGoods(int goodID,String username) {
        return cartGoodsDao.selectCartGoods(goodID,username);
    }

    @Override
    public void addToCartGoods(int goodID, int goodNum,String username) {
        cartGoodsDao.insertCartGoods(goodID,goodNum,username);
    }
}
