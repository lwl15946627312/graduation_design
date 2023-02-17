package com.lwl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMVCConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/toLogin")
                .excludePathPatterns("/adminLogin")
                .excludePathPatterns("/teacherLogin")
                .excludePathPatterns("/studentLogin");
    }

    @Bean("interceptor")
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
}
