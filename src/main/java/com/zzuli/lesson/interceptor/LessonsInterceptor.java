package com.zzuli.lesson.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zzuli.lesson.service.JedisService;

@Component
public class LessonsInterceptor implements HandlerInterceptor {
    @Autowired
    private JedisService jedisService;
    

    @Override  //在请求处理之前进行调用（Controller方法调用之前）
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
    	String url = httpServletRequest.getServletPath(); 
    	String [] urls = url.split("\\/");
    	int x = urls.length;	
    	if(x>3) {  // 如果存在文章id 
    		String id = urls[3];
    		jedisService.saveNewsClickNum(id);
    	}
       // System.out.println("被one拦截，放行...");
        return true;   // 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override  //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override   //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}

