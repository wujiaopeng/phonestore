package com.wwp.phonestore.back.dao;

import com.wwp.phonestore.pojo.Order;
import com.wwp.phonestore.pojo.OrderGoods;
import com.wwp.phonestore.pojo.ShoppingCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("orderDao")
public interface OrderDao {

    //通过条件查询所有的订单
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select10")
    public List<Order> getOrdersList(Map<String,Object> map);

    //通过条件查询出满足条件的记录条数
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select11")
    public int getOrdersCount(Map<String,Object> map);

    @Select("select id from `order` ")
    public List<Integer> getOidList();

    @Update("update `order` set total = 0")
    public int updateOrder();

    @Update("update `order` set total=total + #{total} where id=#{oid}")
    public int updateOrderById(float total,Integer oid);

    //通过id查询对应的订单记录
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select12")
    public Order getOrder(Integer oid);

    //通过订单id查找订单下的商品
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select13")
    public List<OrderGoods> getOrderGoodsList(Integer oid);

    //根据条件获取所有购物车信息
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select14")
    public List<ShoppingCar> getShoppingCarList(Map<String,Object> map);

    //根据条件获取所有购物车条数
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select15")
    public int getShoppingCarCount(Map<String,Object> map);

    //通过id获取购物车信息
    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select16")
    public ShoppingCar getShoppingCarById(Integer sid);



}
