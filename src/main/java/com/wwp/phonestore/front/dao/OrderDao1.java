package com.wwp.phonestore.front.dao;

import com.wwp.phonestore.pojo.Comment;
import com.wwp.phonestore.pojo.Order;
import com.wwp.phonestore.pojo.OrderGoods;
import com.wwp.phonestore.pojo.ShoppingCar;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("orderDao1")
public interface OrderDao1 {

    //点击购买添加订单
    @InsertProvider(type=SqlProvider.class,method = "insert1")
    public int addOrder(Order order);

    //通过订单号查询订单id
    @Select("select id from `order` where orderNo=#{orderNo}")
    public int getOrderId(String orderNo);

    //添加订单中的商品
    @Insert("insert into ordergoods(goodsId,orderId,number) values(#{goodsId},#{orderId},#{number})")
    public int addOrderGoods(OrderGoods orderGoods);

    //查看订单通过id
    @SelectProvider(type=SqlProvider.class,method = "select5")
    public Order getOrderById(Integer oid);

    //通过用户id查询所有的订单信息
    @SelectProvider(type=SqlProvider.class,method = "select7")
    public List<Order> getOrderList(Integer cid,Integer state);

    //通过订单id查找订单下的商品
    @SelectProvider(type= SqlProvider.class,method = "select6")
    public List<OrderGoods> getOrderGoodsList(Integer oid);

    //通过订单id改变订单状态
    @Update("update `order` set orderState=1 where id=#{oid}")
    public int updateOrderState(Integer oid);

    //添加商品评价
    @Insert("insert into comment(cId,gId,content,createtime) values(#{cId},#{gId},#{content},#{createtime})")
    public int addComment(Comment comment);

    //获得商品评价
    @SelectProvider(type=SqlProvider.class,method = "select3")
    public List<Comment> getGoodsComment(Integer gid);
}
