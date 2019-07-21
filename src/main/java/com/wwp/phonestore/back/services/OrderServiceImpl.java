package com.wwp.phonestore.back.services;


import com.wwp.phonestore.back.dao.OrderDao;
import com.wwp.phonestore.pojo.Order;
import com.wwp.phonestore.pojo.OrderGoods;
import com.wwp.phonestore.pojo.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> getOrdersList(Map<String, Object> map) {
        return orderDao.getOrdersList(map);
    }

    @Override
    public int getOrdersCount(Map<String, Object> map) {
        return orderDao.getOrdersCount(map);
    }

    @Override
    public Order getOrder(Integer oid) {
        return orderDao.getOrder(oid);
    }

    @Override
    public List<OrderGoods> getOrderGoodsList(Integer oid) {
        return orderDao.getOrderGoodsList(oid);
    }

    @Override
    public boolean updateOrderById() {
        List<Integer> oidList=orderDao.getOidList();
        int count=orderDao.updateOrder();
        boolean flag=true;
        if(count>0){
            for(Integer oid:oidList){
                List<OrderGoods> orderGoodsList=orderDao.getOrderGoodsList(oid);
                for(OrderGoods orderGoods:orderGoodsList){
                    float total=orderGoods.getNumber()*orderGoods.getPrice();
                    int num=orderDao.updateOrderById(total,orderGoods.getOrderId());
                    if(num<=0)
                        flag=false;
                }
            }
        }else
            flag=false;
        return flag;
    }

    @Override
    public List<ShoppingCar> getShoppingCarList(Map<String, Object> map) {
        return orderDao.getShoppingCarList(map);
    }

    @Override
    public int getShoppingCarCount(Map<String, Object> map) {
        return orderDao.getShoppingCarCount(map);
    }

    @Override
    public ShoppingCar getShoppingCarById(Integer sid) {
        return orderDao.getShoppingCarById(sid);
    }
}
