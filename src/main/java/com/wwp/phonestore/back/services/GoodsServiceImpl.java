package com.wwp.phonestore.back.services;

import com.wwp.phonestore.back.dao.GoodsDao;
import com.wwp.phonestore.pojo.ColorType;
import com.wwp.phonestore.pojo.GoodState;
import com.wwp.phonestore.pojo.Goods;
import com.wwp.phonestore.pojo.GoodsBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> getGoodsList(Map<String, Object> map) {
        return goodsDao.getGoodsList(map);
    }

    @Override
    public int getGoodsCount(Map<String, Object> map) {
        return goodsDao.getGoodsCount(map);
    }

    @Override
    public List<GoodsBrand> getBrandList() {
        return goodsDao.getBrandList();
    }

    @Override
    public List<GoodState> getGoodStateList() {
        return goodsDao.getGoodStateList();
    }

    @Override
    public List<ColorType> getColorList() {
        return goodsDao.getColorList();
    }

    @Override
    public boolean addGoods(Goods goods) {
        int num=goodsDao.addGoods(goods);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public Goods getGoodsById(Integer gid) {
        return goodsDao.getGoodsById(gid);
    }

    @Override
    public boolean updateGoods(Goods goods) {
        int num=goodsDao.updateGoods(goods);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public boolean delGoods(Integer gid) {
        int num=goodsDao.delGoods(gid);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public boolean updateGoodsState(Integer gid, Integer gstate) {
        int num=goodsDao.updateGoodsState(gid, gstate);
        if(num>0)
            return true;
        return false;
    }
}
