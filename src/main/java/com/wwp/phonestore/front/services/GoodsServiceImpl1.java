package com.wwp.phonestore.front.services;


import com.wwp.phonestore.front.dao.GoodsDao1;
import com.wwp.phonestore.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl1 implements GoodsService1 {
    @Autowired
    private GoodsDao1 goodsDao1;

    @Override
    public List<Goods> getGoodList(Integer bid) {
        List<Goods> goodsList = goodsDao1.getGoodsList(bid);
        return goodsList;
    }

    @Override
    public Goods getGoodById(Integer gid) {

        return goodsDao1.getGoodById(gid);
    }

    @Override
    public int getCountOfInSpC(Integer cid) {
        return goodsDao1.getCountOfInSpC(cid);
    }

    @Override
    public List<ShoppingCar> getGoodListInSpCar(Integer cid) {
        return goodsDao1.getGoodListInSpCar(cid);
    }

    @Override
    public ShoppingCar getShoppingCarByGidAndCid(Integer gid, Integer cid) {
        return goodsDao1.getShoppingCarByGidAndCid(gid,cid);
    }

    @Override
    public boolean addShoppingCar(ShoppingCar shoppingCar) {
        int num=goodsDao1.addShoppingCar(shoppingCar);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public boolean updateShoppingById(Integer scId, Integer number) {
        int num=goodsDao1.updateShoppingById(scId,number);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public boolean delShoppingCarById(Integer scId) {
        int num=goodsDao1.delShoppingCarById(scId);
        if(num>0)
            return true;
        return false;
    }



    @Override
    public boolean updateGoodsById(Integer number, Integer gid) {
        int num=goodsDao1.updateGoodsById(number,gid);
        if(num>0)
            return true;
        return false;
    }



}
