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
	
	
	/**
	 * 热门课程排行
	 * 
	 * @return
	 */
	@RequestMapping(value = "/lessons/index.html", method = RequestMethod.GET)
    public String getIndexInfo(ModelMap modelMap) throws Exception {
		modelMap.addAttribute("pageView",lessonsService.getPageView());
        return "index";
    }
	/**
	 * 获取课程列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/lessons/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getLessonList(@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		PageHelper.startPage(start,size);
		return  lessonsService.getLessonsList();
	}
	/**
	 * 获得课程总数totalCount
	 *
	 * @return
	 */
	@RequestMapping(value = "/lessons/totalCount", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getLessonTotalCount(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", lessonsService.getLessonsTotalCount());
		return map;
	}
	/**
	 * 通过Id获取课程信息
	 * 
	 * @param teacher
	 * @return
	 */
	  @RequestMapping(value = "/lessons/{id}", method = RequestMethod.GET)
	    public String index(@PathVariable("id") int id , ModelMap modelMap) {  //@PathVariable用于定义自定义或动态请求URI
		   modelMap.addAttribute("info",lessonsService.getlessonsInfoById(id));
	       return "info";
	    }
	
	

	
}
