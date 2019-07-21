package com.wwp.phonestore.back.controller;

import com.wwp.phonestore.pojo.ColorType;
import com.wwp.phonestore.pojo.GoodState;
import com.wwp.phonestore.pojo.Goods;
import com.wwp.phonestore.pojo.GoodsBrand;
import com.wwp.phonestore.back.services.GoodsService;
import com.wwp.phonestore.tools.Constants;
import com.wwp.phonestore.tools.PageSupport;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/goodslist")
    public String getGoodsList(Model model,
                               @RequestParam(value="queryGoodName",required=false) String queryGoodName,
                               @RequestParam(value="queryBrand",required=false) String queryBrand,
                               @RequestParam(value="queryState",required=false) String queryState,
                               @RequestParam(value="pageIndex",required=false) String pageIndex) {
        System.out.println("开始pageIndex****************************************"+pageIndex);
        System.out.println("开始querygoodName****************************************"+queryGoodName);
        System.out.println("开始queryBrand****************************************"+queryBrand);
        System.out.println("开始queryState****************************************"+queryState);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("queryGoodName", queryGoodName);
        map.put("queryBrand", queryBrand);
        map.put("queryState",queryState);
        //设置页面容量
        int pageSize= Constants.pageSize;
        //当前页码
        int currentPageNo = 1;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                return "redirect:/syserror";
            }
        }
        System.out.println("开始****************************************"+pageIndex);
        //总数量（表）
        int totalCount	=goodsService.getGoodsCount(map);
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
        List<Goods> goodsList=goodsService.getGoodsList(map);
        System.out.println("==========================="+goodsList.size());
        model.addAttribute("goodsList", goodsList);
        model.addAttribute("queryGoodName",queryGoodName );
        model.addAttribute("queryBrand",queryBrand );
        model.addAttribute("queryState",queryState );
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "back/goodslist";
    }

    @RequestMapping(value="/getBrandList",method= RequestMethod.GET)
    @ResponseBody
    public Object getBrandList() {
        List<GoodsBrand> brandList=goodsService.getBrandList();
        System.out.println("=================="+brandList.size());
        return brandList;
    }

    @RequestMapping(value="/getStateList",method=RequestMethod.GET)
    @ResponseBody
    public Object getStateList() {
        List<GoodState> stateList=goodsService.getGoodStateList();
        return stateList;
    }

    @RequestMapping("/addGoods")
    public String toAddGoods() {
        return "back/addgoods";
    }

    @RequestMapping(value="/getColorList",method=RequestMethod.GET)
    @ResponseBody
    public Object getColorList() {
        List<ColorType> colorList=goodsService.getColorList();
        System.out.println("=================="+colorList.size());
        return colorList;
    }

    @RequestMapping(value="/savegoods",method=RequestMethod.POST)
    public String saveAddGoods(Goods goods, Model model, HttpServletRequest request,
                               @RequestParam(value="uploadImage",required=false) MultipartFile multipartFile) {
        String picPath=null;//定义上传路径
        String path=request.getSession().getServletContext().getRealPath("statics"+File.separator+"images");
        if(!multipartFile.isEmpty()) {
            //获取源文件名
            String  fileName=multipartFile.getOriginalFilename();
            //获取文件后缀
            String fileSuffix= FilenameUtils.getExtension(fileName);
            System.out.println("**************************"+multipartFile.getSize());
            if(multipartFile.getSize()>500000) {
                model.addAttribute(Constants.FILEUPLOAD_ERROR_4);
                return "back/addgoods";
            }else if(fileSuffix.equalsIgnoreCase("jpg")||
                    fileSuffix.equalsIgnoreCase("jpeg")||
                    fileSuffix.equalsIgnoreCase("png")||
                    fileSuffix.equalsIgnoreCase("pneg")||
                    fileSuffix.equalsIgnoreCase("gif")) {
                String newFileName= fileName;
                File file=new File(path,newFileName);
                if(!file.exists()) {
                    file.mkdirs();
                }
                try {
                    multipartFile.transferTo(file);
                    picPath="statics/images/"+newFileName;
                } catch (IOException e) {
                    model.addAttribute(Constants.FILEUPLOAD_ERROR_2);
                    return "back/addgoods";
                }
            }else {
                model.addAttribute(Constants.FILEUPLOAD_ERROR_3);
                return "back/addgoods";
            }
            goods.setSrc(picPath);
            goods.setGoodState(3);
            if(goodsService.addGoods(goods)) {
                return "redirect:/goods/goodslist";
            }
        }
        model.addAttribute(Constants.FILEUPLOAD_ERROR_2);
        return "back/addgoods";
    }

    @RequestMapping("/modifyGoods")
    public String toModifyGoods(Integer gid,Model model) {
        Goods goods=goodsService.getGoodsById(gid);
        model.addAttribute("goods", goods);
        return "back/modifygoods";
    }

    @RequestMapping(value="/savemodifygoods",method=RequestMethod.POST)
    public String saveModifyGoods(Goods goods,Model model,HttpServletRequest request,
                                  @RequestParam(value="uploadImage",required=false) MultipartFile multipartFile) {
        String picPath=null;//定义上传路径
        String path=request.getSession().getServletContext().getRealPath("static"+File.separator+"images");
        if(!multipartFile.isEmpty()) {
            //获取源文件名
            String  fileName=multipartFile.getOriginalFilename();
            //获取文件后缀
            String fileSuffix=FilenameUtils.getExtension(fileName);
            System.out.println("**************************"+multipartFile.getSize());
            if(multipartFile.getSize()>500000) {
                model.addAttribute(Constants.FILEUPLOAD_ERROR_4);
                return "back/modifygoods";
            }else if(fileSuffix.equalsIgnoreCase("jpg")||
                    fileSuffix.equalsIgnoreCase("jpeg")||
                    fileSuffix.equalsIgnoreCase("png")||
                    fileSuffix.equalsIgnoreCase("pneg")||
                    fileSuffix.equalsIgnoreCase("gif")) {
                String newFileName= fileName;
                File file=new File(path,newFileName);
                if(!file.exists()) {
                    file.mkdirs();
                }
                try {
                    multipartFile.transferTo(file);
                    picPath="static/images/"+newFileName;
                } catch (IOException e) {
                    model.addAttribute(Constants.FILEUPLOAD_ERROR_2);
                    return "back/modifygoods";
                }
            }else {
                model.addAttribute(Constants.FILEUPLOAD_ERROR_3);
                return "back/modifygoods";
            }
            goods.setSrc(picPath);
            if(goodsService.updateGoods(goods)) {
                return "redirect:/goods/goodslist";
            }
        }else if(goods.getSrc()!=null) {
            if(goodsService.updateGoods(goods)) {
                return "redirect:/goods/goodslist";
            }
        }
        model.addAttribute(Constants.FILEUPLOAD_ERROR_2);
        return "back/modifygoods";
    }

    @RequestMapping(value = "/goodsview",method = RequestMethod.GET)
    public String getGoodsView(Model model,Integer gid){
        Goods goods=goodsService.getGoodsById(gid);
        model.addAttribute("goods",goods);
        return "back/goodsview";
    }

    @RequestMapping(value="/updateState",method=RequestMethod.GET)
    @ResponseBody
    public Object updateGoodsState(Integer gid,Integer gstate) {
        Map<String,String> map=new HashMap<String,String>();
        System.out.println(gid+"=================="+gstate);
        boolean flag=goodsService.updateGoodsState(gid, gstate);
        if(flag) {
            map.put("resultMsg", "success");
            map.put("errorCode", "0");
        }else {
            map.put("resultMsg", "failed");
        }
        return map;
    }

    @RequestMapping(value="/delGoods",method=RequestMethod.GET)
    @ResponseBody
    public Object deleteGoods(Integer gid){
        Map<String,String> map=new HashMap<String,String>();
        Goods goods=goodsService.getGoodsById(gid);
        if(goods==null){
            map.put("delResult","notexist");
        }else{
            boolean flag=goodsService.delGoods(gid);
            if(flag)
                map.put("delResult","true");
            else
                map.put("delResult","false");
        }
        return map;
    }



}
