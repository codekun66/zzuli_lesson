package com.zzuli.lesson.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String getLessonList(ModelMap modelMap) throws Exception{
		modelMap.addAttribute("backInfo", backLessonsService.getBackLessonsList());
		return "background/lessonsManage" ;
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
}
