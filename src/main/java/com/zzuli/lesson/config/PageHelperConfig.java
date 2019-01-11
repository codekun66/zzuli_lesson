package com.zzuli.lesson.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import com.github.pagehelper.PageHelper;
 
@Configuration
public class PageHelperConfig {
 
    @Bean   //注解@Bean表示启动PageHelper这个拦截器
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect","mysql");    //配置mysql数据库的方言
        p.setProperty("returnPageInfo","check");
        /** 支持通过Mapper接口参数来传递分页参数 */
        p.setProperty("supportMethodsArguments","false");

        pageHelper.setProperties(p);
        System.out.println("pageHelper注入成功！");
        return pageHelper;
    }
}