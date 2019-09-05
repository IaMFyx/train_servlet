package com.ucar.training.service;

import com.ucar.training.entity.CartGoods;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public interface CartGoodsService {
    /**
     *
     * @return
     */
    ArrayList<CartGoods> getAllCartGoods(String username);

    /**
     *
     * @param goodID
     * @param goodNum
     */
    void addToCartGoods(int goodID,int goodNum,String username);

    /**
     *
     * @param goodID
     * @return
     */
    Integer getCartGoods(int goodID,String username);

    /**
     *
     * @param goodID
     */
    void modifyGoodNum(int goodID,int goodNum,String username);

    /**
     *
     * @param goodID
     */
    void delCartGoods(int goodID,String username);

    /**
     *
     */
    void delAllCartGoods(String username);
}
