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

import com.zzuli.lesson.service.LessonsService;
import com.zzuli.lesson.service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	LessonsService lessonsService;
	/*
	 * 教师列表
	 * 
	 * @return
	 * */
	@RequestMapping(value = "/teacher/all",method = RequestMethod.GET)
	public String getValidTeacherList(ModelMap modelMap) throws Exception{
		modelMap.addAttribute("teaInfo", teacherService.getValidTeacherList());
		return "teacher";
	}
	/*
	 * 根据教师ID获取信息
	 * 
	 * @return
	 * */
	@RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
	public String getTeacherInfoByID(@PathVariable("id") int id,ModelMap modelMap){
		modelMap.addAttribute("teaInfo_p", teacherService.getTeacherInfoByID(id));
		//modelMap.addAttribute("tea_lessonInfo", lessonsService.getlessonInfoByTeaId(id));
		return "teacher-content";
	}
}
