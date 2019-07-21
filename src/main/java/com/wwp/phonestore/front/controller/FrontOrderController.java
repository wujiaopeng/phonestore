package com.wwp.phonestore.front.controller;


import com.wwp.phonestore.front.services.GoodsService1;
import com.wwp.phonestore.front.services.OrderService1;
import com.wwp.phonestore.pojo.Comment;
import com.wwp.phonestore.pojo.Customer;
import com.wwp.phonestore.pojo.Order;
import com.wwp.phonestore.pojo.OrderGoods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/")
public class FrontOrderController {

    @Resource
    private OrderService1 orderService1;
    @Resource
    private GoodsService1 goodsService1;

    //异步结算处理添加订单信息
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object AddOrder(@RequestParam float total, HttpSession session){
        Map<String,Object> map=new HashMap<String,Object>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        String orderNo=newDate+result;
        Customer customer=(Customer)(session.getAttribute("customer"));
        Order order=new Order();
        order.setOrderNo(orderNo);order.setAddress(customer.getAddress());order.setCreatedate(new Date());
        order.setCustomerId(customer.getId());order.setOrderState(2);order.setPhone(customer.getPhone());
        order.setTotal(total);
        order.toString();
        if(orderService1.addOrder(order)){
            map.put("oid",orderService1.getOrderID(orderNo));
            map.put("result","success");
        }else{
            map.put("result","failed");
        }
        return map;
    }

    //异步结算处理添加订单信息
    @RequestMapping(value = "/addOrderGoods",method = RequestMethod.POST)
    @ResponseBody
    public Object AddOrderGoods(@RequestParam Integer gid,@RequestParam Integer oid,@RequestParam Integer number){
        Map<String,Object> map=new HashMap<String,Object>();
        OrderGoods orderGoods=new OrderGoods();
        orderGoods.setOrderId(oid);
        orderGoods.setGoodsId(gid);
        orderGoods.setNumber(number);
        if (orderService1.addOrderGoods(orderGoods) && goodsService1.updateGoodsById(number,gid)){
            map.put("res","true");
        }else{
            map.put("res","false");
        }
        return map;
    }

    //锁定订单去支付页面
    @RequestMapping("toplay")
    public String ToPlay(@RequestParam  Integer oid, Model model){
        System.out.println("oid-------------------------"+oid);
        Order order=orderService1.getOrderById(oid);
        List<OrderGoods> orderGoodsList=orderService1.getOrderGoodsList(oid);
        model.addAttribute("order",order);
        model.addAttribute("orderGoodsList",orderGoodsList);
        return "front/pay";
    }

    //异步付款
    @RequestMapping(value = "/playmoney",method = RequestMethod.POST)
    @ResponseBody
    public Object PlayMoney(@RequestParam Integer oid){
        Map<String,Object> map=new HashMap<String,Object>();
        if (orderService1.updateOrderState(oid)){
            map.put("result","true");
        }else{
            map.put("result","false");
        }
        return map;
    }

    //我的订单
    @RequestMapping("/myorder")
    public String myOrder(@RequestParam(value="state",required=false)Integer state,
                          HttpSession session,Model model){
        Integer cid=((Customer)(session.getAttribute("customer"))).getId();
        List<Order> orderList=orderService1.getOrderList(cid,state);
        for(Order order:orderList){
            List<OrderGoods> orderGoodsList=orderService1.getOrderGoodsList(order.getId());
            order.setOrderGoodsList(orderGoodsList);
        }
        model.addAttribute("orderList",orderList);
        return "front/myorder";
    }

    //转到评价页
    @RequestMapping("/tocomment")
    public String toComment(@RequestParam Integer oid, Model model){
        Order order=orderService1.getOrderById(oid);
        List<OrderGoods> orderGoodsList=orderService1.getOrderGoodsList(oid);
        model.addAttribute("order",order);
        model.addAttribute("orderGoodsList",orderGoodsList);
        return "front/comment";
    }

    //发表评论
    @RequestMapping(value = "/commentsubmit",method = RequestMethod.POST)
    @ResponseBody
    public Object commentSubmit(@RequestParam int gid,@RequestParam String content,
                                HttpSession session) {
        System.out.println("===gid=======content======="+gid+content);
        Map<String, Object> map = new HashMap<String, Object>();
        Comment comment=new Comment();
        comment.setcId(((Customer)session.getAttribute("customer")).getId());
        comment.setContent(content);
        comment.setCreatetime(new Date());
        comment.setgId(gid);
        if(orderService1.addComment(comment)){
            map.put("result","true");
        }else{
            map.put("result","falsed");
        }
        return map;
    }
}
