package com.wwp.phonestore.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * 配置静态资源访问
 */
@Configuration
public class MyWebMvcConfigurationSupport implements WebMvcConfigurer {
    final Logger logger= LoggerFactory.getLogger(MyWebMvcConfigurationSupport.class);
    @Autowired
    private MyHandlerInterceptor myHandlerInterceptor;
    /**
     * 重写 父类 WebMvcConfigurationSupport 中的 addViewControllers 方法 可以实现 页面跳转
     * addViewController 设置项目路径根路径
     * setViewName 设置访问根路径跳转到的页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/back").setViewName("redirect:/back/login");
        registry.addViewController("/").setViewName("redirect:/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
/**
     * 重写 父类 WebMvcConfigurationSupport 中的 addResourceHandlers 方法 可以实现 静态资源的访问
     * addResourceHandler 相对路径 项目中 resources 文件夹下文件访问
     * addResourceLocations 绝对路径 url 直接可以访问 resources 下的访问
     * @param registry
     */
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics")
                .addResourceLocations("/**");
    }*/

    /**
     * 重写 父类 WebMvcConfigurationSupport 中的 addInterceptors 方法 可以实现 拦截器配置
     * addPathPatterns 添加拦截器规则
     * excludePathPatterns 用户访问拦截排除
     * @param registry
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/back/login","/back/dologin");
    }
}
