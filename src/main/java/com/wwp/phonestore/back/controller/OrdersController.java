package com.wwp.phonestore.back.controller;

import com.wwp.phonestore.pojo.Order;
import com.wwp.phonestore.pojo.OrderGoods;
import com.wwp.phonestore.pojo.ShoppingCar;
import com.wwp.phonestore.back.services.GoodsService;
import com.wwp.phonestore.back.services.OrderService;
import com.wwp.phonestore.tools.Constants;
import com.wwp.phonestore.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/orderlist")
    public String getOrdersList(Model model,
                                @RequestParam(value="queryName",required=false) String queryName,
                                @RequestParam(value="queryOrderNo",required=false) String queryOrderNo,
                                @RequestParam(value="queryOrderState",required=false) String queryOrderState,
                                @RequestParam(value="pageIndex",required=false) String pageIndex) {
        System.out.println("开始****************************************"+pageIndex);
        System.out.println("开始****************************************"+queryName);
        System.out.println("开始****************************************"+queryOrderNo);
        System.out.println("开始****************************************"+queryOrderState);
        boolean flag=orderService.updateOrderById();
        System.out.println("flag****************************************"+flag);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("queryName", queryName);
        map.put("queryOrderNo", queryOrderNo);
        map.put("queryOrderState",queryOrderState);
        //设置页面容量
        int pageSize= Constants.pageSize;
        //当前页码
        int currentPageNo = 1;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                return "redirect:/syserror";
                //response.sendRedirect("syserror.jsp");
            }
        }
        System.out.println("开始****************************************"+pageIndex);
        //总数量（表）
        int totalCount	=orderService.getOrdersCount(map);
        //总页数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();//总页数
        System.out.println("*********************************"+totalPageCount);
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        System.out.println("*********************************"+(currentPageNo-1)*pageSize);
        map.put("currentPageNo", (currentPageNo-1)*pageSize);
        map.put("pageSize", pageSize);
        List<Order> ordersList=orderService.getOrdersList(map);
        System.out.println("==========================="+ordersList.size());
        model.addAttribute("ordersList", ordersList);
        model.addAttribute("queryName",queryName );
        model.addAttribute("queryOrderNo",queryOrderNo );
        model.addAttribute("queryOrderState",queryOrderState );
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "back/orderlist";
    }

    @RequestMapping("/getOrder")
    public String getOrderView(Model model,Integer oid) {
        Order order=orderService.getOrder(oid);
        List<OrderGoods> ordergoodsList=orderService.getOrderGoodsList(oid);
        model.addAttribute("order", order);
        model.addAttribute("ordergoodsList", ordergoodsList);
        return "back/orderview";
    }

    @RequestMapping("/shoppingcarlist")
    public String getShoppingCarList(Model model,
                                     @RequestParam(value="queryGoodsName",required=false) String queryGoodsName,
                                     @RequestParam(value="queryCustomerName",required=false) String queryCustomerName,
                                     @RequestParam(value="queryBrand",required=false) String queryBrand,
                                     @RequestParam(value="pageIndex",required=false) String pageIndex) {
        System.out.println("开始****************************************"+pageIndex);
        System.out.println("开始****************************************"+queryGoodsName);
        System.out.println("开始****************************************"+queryCustomerName);
        System.out.println("开始queryBrand****************************************"+queryBrand);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("queryGoodsName", queryGoodsName);
        map.put("queryCustomerName", queryCustomerName);
        map.put("queryBrand",queryBrand);
        //设置页面容量
        int pageSize=Constants.pageSize;
        //当前页码
        int currentPageNo = 1;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                return "redirect:/syserror";
                //response.sendRedirect("syserror.jsp");
            }
        }
        System.out.println("开始****************************************"+pageIndex);
        //总数量（表）
        int totalCount	=orderService.getShoppingCarCount(map);
        System.out.println("=====count======================"+totalCount);
        //总页数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();//总页数
        System.out.println("*********************************"+totalPageCount);
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        System.out.println("*********************************"+(currentPageNo-1)*pageSize);
        map.put("currentPageNo", (currentPageNo-1)*pageSize);
        map.put("pageSize", pageSize);
        List<ShoppingCar> shoppingcarList=orderService.getShoppingCarList(map);
        System.out.println("==========================="+shoppingcarList.size());
        model.addAttribute("shoppingcarList", shoppingcarList);
        model.addAttribute("queryGoodsName",queryGoodsName );
        model.addAttribute("queryCustomerName",queryCustomerName );
        model.addAttribute("queryBrand",queryBrand );
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "back/shoppingcarlist";
    }

    @RequestMapping("/shoppingcar")
    public String getShoppingCar(Model model,Integer sid) {
        System.out.println("==========================="+sid);
        ShoppingCar shoppingcar=orderService.getShoppingCarById(sid);
        System.out.println("==========================="+shoppingcar.getSrc());
        model.addAttribute("shoppingcar", shoppingcar);
        return "back/shoppingcar";
    }
}
