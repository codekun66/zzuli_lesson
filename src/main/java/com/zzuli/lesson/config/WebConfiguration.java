package com.zzuli.lesson.config;

import com.zzuli.lesson.interceptor.LessonsInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 将拦截器添加到springboot配置中
 * Created by  19.1.08
 * @author xk
 */
@Component
public class WebConfiguration extends WebMvcConfigurerAdapter{
    @Autowired
    private LessonsInterceptor lessonsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        registry.addInterceptor(lessonsInterceptor).addPathPatterns("/lessons/**");
        super.addInterceptors(registry);
    }
}