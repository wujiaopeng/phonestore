package com.wwp.phonestore.front.controller;

import com.wwp.phonestore.front.services.GoodsService1;
import com.wwp.phonestore.front.services.UserService;
import com.wwp.phonestore.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/")
public class FrontIndexController {
    @Resource
    private GoodsService1 goodsService;
    @Resource
    private UserService userService;


    //登陆ajax判断
    @RequestMapping(value = "/checklogin",method = RequestMethod.POST)
    @ResponseBody
    public Object checkLogin(HttpSession session, @RequestParam String account, @RequestParam String password){
        Map<String,Object> map=new HashMap<String,Object>();
        Customer customer=userService.checkAccount(account);
        if(customer!=null){
            if(customer.getPassword().equals(password)){
                session.setAttribute("customer",customer);
                map.put("result","success");
            }else{
                map.put("error",2);
            }
        }else{
            map.put("error",1);
        }
        return map;
    }

    //进入主页
    @RequestMapping("/index")
    public String toIndex(Model model){
        List<Goods> goodsList =goodsService.getGoodList(null);
        if(goodsList!=null){
            model.addAttribute("goodsList",goodsList);
        }else{
            System.out.println("-----------》获取商品列表失败！");
        }
        return "front/index";
    }

    //退出登录
    @RequestMapping("/logout")
    public String Logout(HttpSession session){
        System.out.println("--------------退出登录");
        if(session!=null){
            session.invalidate();//关闭session
        }
        return "redirect:/index";
    }

    //去注册页面
    @RequestMapping(value = "/toregister")
    public String toRegister()
    {
        return "front/register";
    }

    //异步请求判断账号是否存在
    @RequestMapping(value = "/checkaccount",method = RequestMethod.POST)
    @ResponseBody
    public Object checkAccount(@RequestParam String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        Customer customer=userService.checkAccount(account);
        if(customer!=null){
            map.put("result","exit");
        }else{
            map.put("result","noexit");
        }
        return map;
    }

    //注册用户
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String AddUser(Customer customer,Model model){
        customer.setCreatetime(new Date());
        if(userService.addUser(customer)){
            return "redirect:/index";
        }
        return "front/register";
    }


}
