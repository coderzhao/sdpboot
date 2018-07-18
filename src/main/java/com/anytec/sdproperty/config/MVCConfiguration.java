package com.anytec.sdproperty.config;

import com.anytec.sdproperty.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@Configuration

public class MVCConfiguration implements WebMvcConfigurer {

    //请求直接映射页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/video_index").setViewName("video_index");
        registry.addViewController("/manage_index").setViewName("manage_index");
        registry.addViewController("/login").setViewName("login");
    }

    //静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //相对路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //绝对路径
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/data/upload/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:/data/images/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/static/html/**","/video_index","/manage_index").excludePathPatterns("/login");
    }
}
