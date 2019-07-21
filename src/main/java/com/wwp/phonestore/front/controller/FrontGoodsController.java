package com.wwp.phonestore.front.controller;

import com.wwp.phonestore.front.services.GoodsService1;
import com.wwp.phonestore.front.services.OrderService1;
import com.wwp.phonestore.pojo.Comment;
import com.wwp.phonestore.pojo.Customer;
import com.wwp.phonestore.pojo.Goods;
import com.wwp.phonestore.pojo.ShoppingCar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class FrontGoodsController {
    @Resource
    private GoodsService1 goodsService1;
    @Resource
    private OrderService1 orderService1;

    //商品详情页
    @RequestMapping("/tophonemsg")
    public String toPhoneMsg(@RequestParam int gId, Model model){
        Goods goods=goodsService1.getGoodById(gId);
        System.out.println(goods.getGoodName());
        if(goods!=null){
            model.addAttribute("goods",goods);
        }else{
            System.out.println("获取商品详情失败");
        }

        List<Comment> commentList = orderService1.getGoodsComment(gId);
        if(commentList!=null){
            model.addAttribute("commentList",commentList);
        }else{
            System.out.println("获得商品评价失败");
        }
        return "front/phonemsg";
    }

    @RequestMapping("/getbrandphone")
    public String getBrandPhone(@RequestParam Integer brand, Model model){
        List<Goods> goodsList = goodsService1.getGoodList(brand);
        if(goodsList!=null){
            model.addAttribute("goodsList",goodsList);
        }
        return "front/index";
    }

    //ajax异步查询购物车商品数
    @RequestMapping(value = "/getcountofspc",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getCountOfSpC(HttpSession session){
        Map<String,Object> map=new HashMap<String,Object>();
        if(session!=null){
            Integer cid= ((Customer)session.getAttribute("customer")).getId();
            map.put("count",goodsService1.getCountOfInSpC(cid));
        }else{
            map.put("count",0);
        }
        return map;
    }

    //ajax异步查看购物车中是否有该商品
    @RequestMapping(value = "/checkspc",method = RequestMethod.POST)
    @ResponseBody
    public Object CheckSpc(HttpSession session,Integer gid){
        Map<String,Object> map=new HashMap<String,Object>();
        Integer cid=((Customer)(session.getAttribute("customer"))).getId();
        ShoppingCar shoppingCar=goodsService1.getShoppingCarByGidAndCid(gid,cid);
        if(shoppingCar!=null){
            map.put("result","exit");
            map.put("scId",shoppingCar.getId());
            map.put("number",shoppingCar.getNumber());
        }else{
            map.put("result","noexit");
        }
        return map;
    }
    //ajax异步查看购物车中
    @RequestMapping(value = "/addCar",method = RequestMethod.POST)
    @ResponseBody
    public Object AddShoppingCar(HttpSession session,@RequestParam Integer gid){
        Map<String,Object> map=new HashMap<String,Object>();
        Integer cid=((Customer)(session.getAttribute("customer"))).getId();
        ShoppingCar shoppingCar=new ShoppingCar();
        shoppingCar.setGoodId(gid); shoppingCar.setCustomerId(cid);
        shoppingCar.setCreatedate(new Date());
        shoppingCar.setNumber(1);
        if(goodsService1.addShoppingCar(shoppingCar)){
            map.put("res","true");
        }else{
            map.put("res","false");
        }
        return map;
    }

    //跳转到购物车
    @RequestMapping("/toshoppingcar")
    public String toShoppingCar(Model model,HttpSession session){
        Integer cid= ((Customer)(session.getAttribute("customer"))).getId();
        List<ShoppingCar> shoppingCarList =goodsService1.getGoodListInSpCar(cid);
        if(shoppingCarList!=null){
            model.addAttribute("shoppingCarList",shoppingCarList);
        }else{
            System.out.println("-----------》获取商品列表失败！");
        }
        return "front/shoppingcar";
    }

    //异步更改购物车商品数量
    @RequestMapping(value = "/modifyCar",method = RequestMethod.POST)
    @ResponseBody
    public Object modifyShoppingCar(@RequestParam Integer scId,@RequestParam Integer number){
        Map<String,Object> map=new HashMap<String,Object>();
        if(goodsService1.updateShoppingById(scId,number)){
            map.put("result","success");
        }else{
            map.put("result","failed");
        }
        return map;
    }

    //异步通过id删除购物车商品
    @RequestMapping(value = "/deleteCar",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteShoppingCar(@RequestParam Integer scId){
        Map<String,Object> map=new HashMap<String,Object>();
        if(goodsService1.delShoppingCarById(scId)){
            map.put("result","success");
        }else{
            map.put("result","failed");
        }
        return map;
    }

}
