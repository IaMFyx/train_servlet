package com.ucar.training.dao;

import com.ucar.training.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository("goodDao")
public interface GoodDao {
    /**
     *
     * @return
     */
    ArrayList<Goods> selectGoods();

    /**
     *
     * @param keyName
     * @return
     */
    ArrayList<Goods> selectGoodsByName(String keyName);

    /**
     *
     * @param id
     * @return
     */
    Goods selectGood(int id);

    /**
     *
     * @param good
     */
    void insertGood(Goods good);

    /**
     *
     * @param id
     */
    void delGood(int id);

    /**
     *
     * @param good
     */
    void updateGood(Goods good);

    /**
     *
     * @param goodID
     * @param goodNum
     */
    void updateGoodsInventory(int goodID,int goodNum);


}
