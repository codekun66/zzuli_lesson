package com.zzuli.lesson.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzuli.lesson.bean.Lessons;
import com.zzuli.lesson.service.LessonsService;

@Controller
public class LessonsController {

	@Autowired 
	LessonsService lessonsService;
	
	@RequestMapping(value = "/lessons/list", method = RequestMethod.GET)	
    public String getLessonsList(ModelMap modelMap) {
		modelMap.addAttribute("list", lessonsService.getLessonsList());
        return "index";
    }
	@RequestMapping(value = "/lessons/list2", method = RequestMethod.GET)
	@ResponseBody
	public List<Lessons> getLessonList(){
		return lessonsService.getLessonsList();
	}
}
