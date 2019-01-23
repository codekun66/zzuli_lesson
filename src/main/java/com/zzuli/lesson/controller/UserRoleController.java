package com.zzuli.lesson.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {

	@RequestMapping(value = "/admin/getMessage", method = RequestMethod.GET)
	public Map<String, Object> getMessage() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "您拥有管理员权限，可以获得该接口的信息!");
		return map;
	}
	@RequestMapping(value = "/user/getMessage", method = RequestMethod.GET)
	public Map<String, Object> getMessage2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "您拥有管理员权限，可以获得该接口的信息!");
		return map;
	}
	

}
