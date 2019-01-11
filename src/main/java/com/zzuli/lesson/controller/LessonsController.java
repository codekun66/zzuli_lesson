package com.zzuli.lesson.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzuli.lesson.bean.Lessons;
import com.zzuli.lesson.service.LessonsService;
import com.zzuli.lesson.util.RedisUtil;

@Controller
public class LessonsController {

	@Autowired 
	LessonsService lessonsService;

	
	@RequestMapping(value = "/lessons/list", method = RequestMethod.GET)	
    public String getLessonsList(ModelMap modelMap,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		PageHelper.startPage(start,size);
		List<Lessons> list = lessonsService.getLessonsList();
		PageInfo<Lessons> lessonsPage = new PageInfo<>(list);
		modelMap.addAttribute("pageInfo",lessonsPage);
		modelMap.addAttribute("pageView",lessonsService.getPageView());
        return "index";
    }
	@RequestMapping(value = "/lessons/list2", method = RequestMethod.GET)
	@ResponseBody
	public List<Lessons> getLessonList(){
		return lessonsService.getLessonsList2();
	}
    @RequestMapping("/goadd")
    public String goAddPage(){
        return "addLessons";
    }

	@RequestMapping(value = "/lessons/add", method = RequestMethod.POST)
	public String addLessons(Lessons lessons , ModelMap modelMap) {
		int count = lessonsService.addLessons(lessons);
		if(count > 0) {
			return "redirect:list";
		}
		else {
			modelMap.addAttribute("erro","失败");
			return"errro";
		}
	}
	
	  @RequestMapping(value = "/lessons/list/{id}", method = RequestMethod.GET)
	    public String index(@PathVariable("id") int id , ModelMap modelMap) {  //@PathVariable用于定义自定义或动态请求URI
		   modelMap.addAttribute("info",lessonsService.getlessonsInfoById(id));
	       return "info";
	    }
	
	

	
}
