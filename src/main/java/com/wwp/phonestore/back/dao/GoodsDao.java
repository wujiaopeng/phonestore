package com.wwp.phonestore.back.dao;

import com.wwp.phonestore.pojo.ColorType;
import com.wwp.phonestore.pojo.GoodState;
import com.wwp.phonestore.pojo.Goods;
import com.wwp.phonestore.pojo.GoodsBrand;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("goodsDao")
public interface GoodsDao {
    //通过条件查询所有商品
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select7")
    public List<Goods> getGoodsList(Map<String,Object> map);

    //通过条件查询商品条数
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select8")
    public int getGoodsCount(Map<String,Object> map);

    //查询所有的品牌
    @Select("select * from goodsbrand")
    public List<GoodsBrand> getBrandList();

    //查询所有的商品状态
    @Select("select * from goodstate")
    public List<GoodState> getGoodStateList();

    //查询所有商品颜色种类
    @Select("select * from colortype")
    public List<ColorType> getColorList();

    //添加商品
    @InsertProvider(type=PhoneMasterSqlProvider.class,method = "insert3")
    public int addGoods(Goods goods);

    //通过商品id获取商品记录
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select9")
    public Goods getGoodsById(Integer gid);

    //通过商品id更改商品信息
    @UpdateProvider(type=PhoneMasterSqlProvider.class,method = "update3")
    public int  updateGoods(Goods goods);

    //通过id删除该商品
    @Delete("delete from goods where id=#{gid}")
    public int delGoods(Integer gid);

    //通过商品id，对商品上下架
    @Update("update goods set goodState=#{gstate} where id=#{gid}")
    public int updateGoodsState(Integer gid,Integer gstate);

}
