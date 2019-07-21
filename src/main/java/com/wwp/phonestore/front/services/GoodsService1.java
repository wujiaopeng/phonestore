package com.wwp.phonestore.front.services;

import com.wwp.phonestore.pojo.*;

import java.util.List;

public interface GoodsService1 {

    //获取所有的商品
    public List<Goods> getGoodList(Integer bid);

    //通过id查商品
    public Goods getGoodById(Integer gid);


    //获得所有在购物车里的商品的总数
    public int getCountOfInSpC(Integer cid);

    //查找客户添加在购物车里的商品
    public List<ShoppingCar> getGoodListInSpCar(Integer cid);

    //通过客户id和商品id查看购物车是否有商品存在
    public ShoppingCar getShoppingCarByGidAndCid(Integer gid,Integer cid);

    //将商品添加到购物车中
    public boolean addShoppingCar(ShoppingCar shoppingCar);

    //通过id更改购物车商品的数量
    public boolean updateShoppingById(Integer scId,Integer number);

    //通过id删除购物车商品
    public boolean delShoppingCarById(Integer scId);

    //点击购买后，更新商品的库存
    public boolean  updateGoodsById(Integer number,Integer gid);



}
