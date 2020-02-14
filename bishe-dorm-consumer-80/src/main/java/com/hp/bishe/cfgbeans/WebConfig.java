package com.hp.bishe.cfgbeans;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/photo/**").addResourceLocations("file:M:/photo/");
    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //访问/login跳转到登录页面
        registry.addViewController("/dorm").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/gerenxinxiguanli").setViewName("gerenxinxiguanli");
        registry.addViewController("/ruZhuXinXiDengJi").setViewName("ruzhuxinxidengji");
        registry.addViewController("/queQinJiLu").setViewName("queqinjilu");
        registry.addViewController("/weiXiuXinXi").setViewName("/weixiuxinxi");
        registry.addViewController("/weiXiuJiLu").setViewName("weixiujilu");
        registry.addViewController("/jianYiPingJia").setViewName("yijianpingjia");
//        registry.addViewController("/xueShengGuanLi").setViewName("xueShengGuanLi");
//        registry.addViewController("/suSheGuanLi").setViewName("suSheGuanLi");
//        registry.addViewController("/XueShengRuzhuDengJi").setViewName("XueShengRuzhuDengJi");
//        registry.addViewController("/xueShengQinShiTiaoHuan").setViewName("xueShengQinShiTiaoHuan");
//        registry.addViewController("/xueShengQianChu").setViewName("xueShengQianChu");
//        registry.addViewController("/qianChuJiLu").setViewName("qianChuJiLu");
//        registry.addViewController("/Queqin").setViewName("Queqin");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
