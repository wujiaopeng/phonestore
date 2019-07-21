package com.wwp.phonestore.front.dao;



import com.wwp.phonestore.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository("goodsDao1")
public interface GoodsDao1 {

    //获取所有商品信息
    @SelectProvider(type= SqlProvider.class,method = "select1")
    public List<Goods> getGoodsList(Integer bid);

    //通过id查商品
    @SelectProvider(type=SqlProvider.class,method = "select2")
    public Goods getGoodById(Integer gid);


    //查询用户购物车中的数量
    @Select("select count(1) as count from shoppingcar where customerId=#{cid}")
    public int getCountOfInSpC(Integer cid);

    //查找客户添加在购物车里的商品
    @SelectProvider(type=SqlProvider.class,method = "select4")
    public List<ShoppingCar> getGoodListInSpCar(Integer cid);

    //通过客户id和商品id查看购物车是否有商品存在
    @Select("select * from shoppingcar where goodId=#{gid} and customerId=#{cid}")
    public ShoppingCar getShoppingCarByGidAndCid(Integer gid,Integer cid);

    //将商品添加到购物车中
    @Insert("insert into shoppingcar(goodId,customerId,number,createdate) values(#{goodId}," +
            " #{customerId},#{number},#{createdate})")
    public int addShoppingCar(ShoppingCar shoppingCar);

    //通过id更改购物车商品的数量
    @Update("update shoppingcar set number=#{number} where id=#{scId}")
    public int updateShoppingById(Integer scId,Integer number);

    //通过id删除购物车商品
    @Delete("delete from shoppingcar where id=#{scId}")
    public int delShoppingCarById(Integer scId);

    //点击购买后，更新商品的库存
    @Update("update goods set stock = stock-#{number} where id=#{gid}")
    public int updateGoodsById(Integer number,Integer gid);


}
