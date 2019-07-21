package com.wwp.phonestore.front.services;

import com.wwp.phonestore.pojo.Comment;
import com.wwp.phonestore.pojo.Order;
import com.wwp.phonestore.pojo.OrderGoods;

import java.util.List;

public interface OrderService1 {

    //添加商品评价
    public boolean addComment(Comment comment);

    //获得商品评价
    public List<Comment> getGoodsComment(Integer gid);

    //添加订单
    public boolean addOrder(Order order);

    //通过订单编号获取订单id
    public int getOrderID(String orderNo);

    //通过用户id查询所有的订单信息
    public List<Order> getOrderList(Integer cid,Integer state);

    //添加订单下的商品
    public boolean addOrderGoods(OrderGoods orderGoods);

    //查看订单通过id
    public Order getOrderById(Integer oid);

    //通过订单id查找订单下的商品
    public List<OrderGoods> getOrderGoodsList(Integer oid);

    //通过id改变订单状态
    public boolean updateOrderState(Integer oid);
}
