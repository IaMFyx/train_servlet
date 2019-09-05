package com.ucar.training.dao;

import com.ucar.training.entity.CartGoods;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CartGoodsDao {
    /**
     *
     * @return
     */
    ArrayList<CartGoods> selectAll(String username);

    /**
     *
     * @param goodID
     * @param goodNum
     */
    void insertCartGoods(int goodID,int goodNum,String username);

    /**
     *
     * @param goodID
     * @return
     */
    Integer selectCartGoods(int goodID,String username);

    /**
     *
     * @param goodID
     */
    void updateCartGoods(int goodID,int goodNum,String username);
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
