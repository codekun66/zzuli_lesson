package com.zzuli.lesson.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 等同于 @Controler @ResponseBody
 *
 * @author xk		
 * @date 2018/11/26
 */
@Controller //提供实现了REST API，可以服务JSON,XML或者其他。这里是以String的形式渲染出结果
public class HelloController {
	
	@RequestMapping("/api/cityview") //配置url映射
	public String index() {
		return "index";
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public Map<String , String> get(@RequestParam String name){
		Map<String, String> map = new HashMap<String , String>();
		map.put("name", name);
		map.put("value", "hello");
		return map;
	}
	
	
	
	/* public String hello()
	 {
		return "Hello spring boot";
	 }*/
}
