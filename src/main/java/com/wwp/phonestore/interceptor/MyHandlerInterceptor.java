package com.wwp.phonestore.interceptor;

import com.wwp.phonestore.pojo.Customer;
import com.wwp.phonestore.pojo.Master;
import com.wwp.phonestore.tools.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class MyHandlerInterceptor extends HandlerInterceptorAdapter {
    Logger logger= LoggerFactory.getLogger(MyHandlerInterceptor.class);
    //定义不需要拦截的访问路径
    public static final String[] IGNORE_URL={"/index","/checklogin","/toregister","/checkaccount","/register",
                      "/getbrandphone","/tophonemsg","/login","/back/login","/back/dologin","statics/"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag=false;
        String path=request.getServletPath();

        for(String url:IGNORE_URL){
            if(path.contains(url)){
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("------------------------拦截成功------------------------------");
            if(request.getServletPath().contains("/back") ||
                    request.getServletPath().contains("/system") ||
                    request.getServletPath().contains("/order") ||
                    request.getServletPath().contains("/goods")){
                Master master=(Master)request.getSession().getAttribute(Constants.USER_SESSION);
                if(master==null){
                    //request.setAttribute("error","你还没登录!");
                    response.sendRedirect(request.getContextPath()+"/back/login");
                    flag=false;
                }else{
                    flag=true;
                }
            }else{
                Customer customer=(Customer)request.getSession().getAttribute("customer");
                if(customer==null){
                    response.sendRedirect(request.getContextPath()+"/index");
                    flag=false;
                }else{
                    flag=true;
                }
            }

        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
