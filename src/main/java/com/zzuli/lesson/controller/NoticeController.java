package com.zzuli.lesson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {
	
	
	/**
	 * 
	 * 公告展示
	 * 
	 */
	@RequestMapping(value = "/lessons/natice.html", method = RequestMethod.GET)
	public String getNoticeInfo() throws Exception {
		return "natice";
	}
}
