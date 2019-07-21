package com.wwp.phonestore.back.services;

import com.wwp.phonestore.pojo.Order;
import com.wwp.phonestore.pojo.OrderGoods;
import com.wwp.phonestore.pojo.ShoppingCar;

import java.util.List;
import java.util.Map;

public interface OrderService {

    public List<Order> getOrdersList(Map<String,Object> map);

    public int getOrdersCount(Map<String,Object> map);

    public Order getOrder(Integer oid);

    public List<OrderGoods> getOrderGoodsList(Integer oid);

    public boolean updateOrderById();

    public List<ShoppingCar> getShoppingCarList(Map<String,Object> map);

    public int getShoppingCarCount(Map<String,Object> map);

    public ShoppingCar getShoppingCarById(Integer sid);
}
