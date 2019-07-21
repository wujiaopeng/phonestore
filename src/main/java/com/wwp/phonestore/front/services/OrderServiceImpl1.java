package com.wwp.phonestore.front.services;


import com.wwp.phonestore.front.dao.OrderDao1;
import com.wwp.phonestore.pojo.Comment;
import com.wwp.phonestore.pojo.Order;
import com.wwp.phonestore.pojo.OrderGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl1 implements OrderService1 {

    @Autowired
    private OrderDao1 orderDao1;

    @Override
    public List<Comment> getGoodsComment(Integer gid) {

        return orderDao1.getGoodsComment(gid);
    }

    @Override
    public boolean addOrder(Order order) {
        int num=orderDao1.addOrder(order);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public int getOrderID(String orderNo) {
        return orderDao1.getOrderId(orderNo);
    }

    @Override
    public List<Order> getOrderList(Integer cid, Integer state) {
        return orderDao1.getOrderList(cid,state);
    }

    @Override
    public boolean addOrderGoods(OrderGoods orderGoods) {
        int num=orderDao1.addOrderGoods(orderGoods);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public Order getOrderById(Integer oid) {
        return orderDao1.getOrderById(oid);
    }

    @Override
    public List<OrderGoods> getOrderGoodsList(Integer oid) {
        return orderDao1.getOrderGoodsList(oid);
    }

    @Override
    public boolean updateOrderState(Integer oid) {
        int num=orderDao1.updateOrderState(oid);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public boolean addComment(Comment comment) {
        int num=orderDao1.addComment(comment);
        if(num>0)
            return true;
        return false;
    }

}
