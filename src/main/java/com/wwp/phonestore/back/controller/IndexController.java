package com.wwp.phonestore.back.controller;

import com.wwp.phonestore.pojo.Master;
import com.wwp.phonestore.back.services.MasterService;
import com.wwp.phonestore.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/back")
public class IndexController {
    @Autowired
    private MasterService masterService;

    @RequestMapping("/login")
    public String toLogin(HttpServletRequest request, @ModelAttribute String error){

        if(error != null){
            request.setAttribute("error", error);
        }
        return "back/login";
    }

    @RequestMapping(value="/dologin",method = RequestMethod.POST)
    public String doLogin(@RequestParam String account,
                          @RequestParam String password,
                          RedirectAttributes attr,
                          HttpSession session){
        Master master=masterService.getMasterByName(account);
        if(master!=null){
            if(master.getPassword().equals(password)){
                master.setPassword("");
                session.setAttribute(Constants.USER_SESSION,master);
                return "back/index";
            }else{
                attr.addFlashAttribute("error", "密码错误！");
                return "redirect:/back/login";
            }
        }else {
            attr.addFlashAttribute("error", "账号或密码错误！");
            return "redirect:/back/login";
        }
    }

    @RequestMapping("/logout")
    public String loginOut(HttpSession session){
        session.setAttribute(Constants.USER_SESSION,null);
        return "back/login";
    }
}
