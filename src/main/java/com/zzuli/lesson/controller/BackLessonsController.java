package com.zzuli.lesson.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzuli.lesson.bean.Lessons;
import com.zzuli.lesson.service.BackLessonsService;
import com.zzuli.lesson.service.LoginService;

@Controller
public class BackLessonsController {

	@Autowired 
	private LoginService loginService;
	@Autowired
	private BackLessonsService backLessonsService;

	@RequestMapping(value = "/back/lessonsInfo", method = RequestMethod.GET)
	public String getLessonAdminList(ModelMap modelMap) throws Exception{
		modelMap.addAttribute("backInfo", backLessonsService.getBackLessonsList());
		return "background/background-table" ;
	}
	
	@RequestMapping(value = "/back/lessonsInfoAdmin", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getLessonAdminListjson() throws Exception{
		//String role = loginService.getRole(username);
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list = backLessonsService.getBackLessonsList();
	//	Map<String, Object> map = new HashMap<>();
	//	String Role = loginService.getRole(token.getPrincipal().toString());
	//	int userId = loginService.getUserId(token.getPrincipal().toString());
	//	map.put("role", Role);
	//	map.put("userId", userId);
	//	list.add(map);
		return list ;
	}	
	
	@RequestMapping(value = "/back/lessonsInfoTea/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getLessonTeacherList(@PathVariable("userId") int userId ,ModelMap modelMap ) throws Exception{
		//modelMap.addAttribute("backInfo", backLessonsService.getBackLessonsListTeacher(userId));
		return backLessonsService.getBackLessonsListTeacher(userId);
	}
	
    @RequestMapping("back/lessonAdd.html")
    public String goAddPage(){
        return "background/lessonsAdd";
    }

	@RequestMapping(value = "/back/lessonsAdd", method = RequestMethod.POST)
	@ResponseBody
	public String addLessons(@RequestBody Lessons lessons , ModelMap modelMap,HttpServletRequest request) {
		System.out.println(lessons.toString());
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
