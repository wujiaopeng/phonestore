package com.wwp.phonestore.back.services;


import com.wwp.phonestore.pojo.ColorType;
import com.wwp.phonestore.pojo.GoodState;
import com.wwp.phonestore.pojo.Goods;
import com.wwp.phonestore.pojo.GoodsBrand;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    public List<Goods> getGoodsList(Map<String,Object> map);

    public int getGoodsCount(Map<String,Object> map);

    public List<GoodsBrand> getBrandList();

    public List<GoodState> getGoodStateList();

    public List<ColorType> getColorList();

    public boolean addGoods(Goods goods);

    public Goods getGoodsById(Integer gid);

    public boolean  updateGoods(Goods goods);

    public boolean delGoods(Integer gid);

    public boolean updateGoodsState(Integer gid,Integer gstate);
}
