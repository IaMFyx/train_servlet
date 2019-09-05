package com.ucar.training.service;

import com.ucar.training.entity.Goods;

import java.util.ArrayList;

public interface GoodService {
    /**
     *
     * @return
     */
    ArrayList<Goods> getAllGoods();

    /**
     *
     * @param id
     * @return
     */
    Goods getGood(int id);

    /**
     *
     * @param keyName
     * @return
     */
    ArrayList<Goods> selectGoodsByName(String keyName);
    /**
     *
     * @param good
     */
    void addGood(Goods good);

    /**
     *
     * @param id
     */
    void delGood(int id);

    /**
     *
     * @param good
     */
    void modifyGood(Goods good);

    /**
     *
     * @param goodID
     * @param goodNum
     */
    void modifyGoodsNum(int goodID,int goodNum);
}
