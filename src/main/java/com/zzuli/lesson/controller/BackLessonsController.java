package com.zzuli.lesson.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzuli.lesson.bean.Lessons;
import com.zzuli.lesson.service.BackLessonsService;

@Controller
public class BackLessonsController {

	@Autowired
	private BackLessonsService backLessonsService;

	@RequestMapping(value = "/back/lessonsInfo", method = RequestMethod.GET)
	public String getLessonAdminList(ModelMap modelMap) throws Exception{
		modelMap.addAttribute("backInfo", backLessonsService.getBackLessonsList());
		return "background/background-table" ;
	}	
	
	@RequestMapping(value = "/back/lessonsInfojson", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getLessonAdminListjson() throws Exception{
		return backLessonsService.getBackLessonsList() ;
	}	
	
	@RequestMapping(value = "/back/lessonsInfoTea/{userId}", method = RequestMethod.GET)
	public String getLessonTeacherList(@PathVariable("userId") int userId ,ModelMap modelMap ) throws Exception{
		modelMap.addAttribute("backInfo", backLessonsService.getBackLessonsListTeacher(userId));
		return "background/lessonsManage";
	}
	
    @RequestMapping("back/lessonAdd.html")
    public String goAddPage(){
        return "background/lessonsAdd";
    }

	@RequestMapping(value = "/back/lessonsAdd", method = RequestMethod.POST)
	public String addLessons(Lessons lessons , ModelMap modelMap) {
		int count = backLessonsService.addLessons(lessons);
		if(count > 0) {
			return "redirect:lessonsInfo";
		}
		else {
			modelMap.addAttribute("erro","失败");
			return"errro";
		}
	}
	
	  @RequestMapping(value = "/back/deleteLessons/{id}", method = RequestMethod.GET)
	  @ResponseBody
	    public Map<String, Object> deleteLesson(@PathVariable("id") int id , ModelMap modelMap) {  //@PathVariable用于定义自定义或动态请求URI
		  int count =backLessonsService.deleteLessonsById(id);
		  Map<String, Object> map  = new HashMap<>();
		  if(count > 0) {
			  map.put("msg", "succes");
				
			}
		  else {
			  map.put("msg", "error");
				
			}
		  return map;   
	    }
	
}
