package com.wwp.phonestore.back.controller;

import com.wwp.phonestore.pojo.Customer;
import com.wwp.phonestore.pojo.Master;
import com.wwp.phonestore.back.services.CustomerService;
import com.wwp.phonestore.back.services.MasterService;
import com.wwp.phonestore.tools.Constants;
import com.wwp.phonestore.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MasterService masterService;

    @RequestMapping("/customerlist")
    public String getCustomerList(Model model,
                                  @RequestParam(value="queryname",required=false) String queryname,
                                  @RequestParam(value="pageIndex",required=false) String pageIndex) {
        System.out.println("开始****************************************"+pageIndex);
        System.out.println("开始****************************************"+queryname);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("queryname", queryname);
        //设置页面容量
        int pageSize= Constants.pageSize;
        //当前页码
        int currentPageNo = 1;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                return "redirect:/user/syserror.html";
                //response.sendRedirect("syserror.jsp");
            }
        }
        System.out.println("开始****************************************"+pageIndex);
        //总数量（表）
        int totalCount	=customerService.getCustomerCount(queryname);
        //总页数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();//总页数
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        System.out.println("*********************************"+(currentPageNo-1)*pageSize);
        map.put("currentPageNo", (currentPageNo-1)*pageSize);
        map.put("pageSize", pageSize);
        List<Customer> customerList=customerService.getCustomerList(map);
        model.addAttribute("customerList", customerList);
        model.addAttribute("queryname",queryname );
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);

        return "back/customerlist";

    }
    @RequestMapping("/addCustomer")
    public String addCustomer() {
        return "back/addcustomer";
    }

    @RequestMapping("/isAccount")
    @ResponseBody
    public Object IsAccountExit(String account) {
        Map<String,String> map=new HashMap<String,String>();
        if(account==null || account.equals("")) {
            map.put("account", "empty");
        }else {
            Customer customer=customerService.getCustomer(null, account);
            if(customer!=null)
                map.put("account", "exist");
            else
                map.put("account", "noexist");
        }
        return map;
    }

    @RequestMapping(value="/savecustomer",method = RequestMethod.POST)
    public String saveCustomer(Model model,Customer customer) {
        System.out.println("----------------------------------开始");
        customer.setCreatetime(new Date());
        boolean flag=customerService.addCustomer(customer);
        if(flag) {
            return "redirect:/system/customerlist";
        }else {
            return "back/addcustomer";
        }
    }

    @RequestMapping("/modifycustomer")
    public String toModifyCustomer(Model model,Integer cid) {
        Customer customer=customerService.getCustomer(cid, null);
        model.addAttribute("customer", customer);
        return "back/modifycustomer";
    }

    @RequestMapping(value="/savemidifycustomer",method = RequestMethod.POST)
    public String saveModifyCustomer(Model model,Customer customer) {
        System.out.println("----------------------------------开始");
        boolean flag=customerService.updateCustomer(customer);
        if(flag) {
            return "redirect:/system/customerlist";
        }else {
            return "back/modifycustomer";
        }
    }

    @RequestMapping("/delCustomer")
    @ResponseBody
    public Object deleteCustomer(Integer cid) {
        Map<String,String> map=new HashMap<String,String>();
        Customer customer=customerService.getCustomer(cid, null);
        if(customer==null) {
            map.put("delResult", "notexist");
        }else {
            boolean flag=customerService.delCustomer(cid);
            if(flag)
                map.put("delResult", "true");
            else
                map.put("delResult", "false");
        }
        return map;
    }

    @RequestMapping("/masterlist")
    public String toMasterList(Model model,
                               @RequestParam(value="queryname",required=false) String queryname,
                               @RequestParam(value="pageIndex",required=false) String pageIndex) {
        System.out.println("开始****************************************"+queryname);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("queryname", queryname);
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
        System.out.println("queryname****************************************"+queryname);
        //总数量（表）
        int totalCount	=masterService.getMasterCount(queryname);
        System.out.println("*********************************"+totalCount);
        //总页数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();//总页数
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        System.out.println("*********************************"+(currentPageNo-1)*pageSize);
        map.put("currentPageNo", (currentPageNo-1)*pageSize);
        map.put("pageSize", pageSize);
        List<Master> masterList=masterService.getMasterList(map);
        model.addAttribute("masterList", masterList);
        model.addAttribute("queryname",queryname );
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "back/masterlist";
    }

    @RequestMapping("/addMaster")
    public String addMaster() {
        return "back/addmaster";
    }

    @RequestMapping("/isAccount1")
    @ResponseBody
    public Object IsAccountExit1(String account) {
        Map<String,String> map=new HashMap<String,String>();
        if(account==null || account.equals("")) {
            map.put("account", "empty");
        }else {
            Master master=masterService.getMaster(null, account);
            if(master!=null)
                map.put("account", "exist");
            else
                map.put("account", "noexist");
        }
        return map;
    }

    @RequestMapping(value="/savemaster",method = RequestMethod.POST)
    public String saveMaster(Model model,Master master) {
        System.out.println("----------------------------------开始");
        master.setCreatetime(new Date());
        boolean flag=masterService.addMaster(master);
        if(flag) {
            return "redirect:/system/masterlist";
        }else {
            return "back/addmaster";
        }
    }

    @RequestMapping("/modifymaster")
    public String toModifyMaster(Model model,Integer mid) {
        Master master=masterService.getMaster(mid, null);
        model.addAttribute("master", master);
        return "back/modifymaster";
    }

    @RequestMapping(value="/savemidifymaster",method = RequestMethod.POST)
    public String saveModifyMaster(Model model,Master master) {
        System.out.println("----------------------------------开始");
        boolean flag=masterService.updateMaster(master);
        if(flag) {
            return "redirect:/system/masterlist";
        }else {
            return "back/modifymaster";
        }
    }

    @RequestMapping("/delMaster")
    @ResponseBody
    public Object deleteMaster(Integer mid) {
        Map<String,String> map=new HashMap<String,String>();
        Master master=masterService.getMaster(mid, null);
        if(master==null) {
            map.put("delResult", "notexist");
        }else {
            boolean flag=masterService.deleteMaster(mid);
            if(flag)
                map.put("delResult", "true");
            else
                map.put("delResult", "false");
        }
        return map;
    }

}
