package com.zzuli.lesson.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.zzuli.lesson.bean.Lessons;
import com.zzuli.lesson.bean.User;
import com.zzuli.lesson.mapper.LoginMapper;
import com.zzuli.lesson.service.BackLessonsService;
import com.zzuli.lesson.service.LoginService;
import com.zzuli.lesson.util.ConstantUtil;

import javassist.expr.NewArray;

@Controller
public class LoginController {

	@Autowired
	private BackLessonsService backLessonsService;
    @Autowired 
    private LoginService loginService;
	
	@RequestMapping(value = "/notLogin", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> notLogin() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "您尚未登陆！");
		return map;
	}
	@RequestMapping(value = "/notRole", method = RequestMethod.GET)
	@ResponseBody
    public Map<String, Object> notRole() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "您没有权限！");
        return map;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> logout() {
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "成功注销！");
        return map;
    }
    
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String toLogin () {
    	return "login";
    }
    
    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
 	public String toRegister () {
     	return "register";
     }
	 /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
	 * @throws Exception 
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> backLogin(String username, String password ) throws Exception {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆   封装了用户名，密码的 token 作为参数传入
        subject.login(token);
        //根据权限，指定返回数据
        String role = loginService.getRole(username);
        String sessionId = (String) subject.getSession().getId();
        Session session =  subject.getSession();
        Map<String, Object> map = new HashMap<>();
        int userId = loginService.getUserId(username);
        String teaName = loginService.getTeaName(username);
        	//modelMap.addAttribute("backInfo", backLessonsService.getBackLessonsList());
    		//return "background/background-table" ;
/*        	Cookie cookie = new Cookie("sessionId",sessionId);
        	response.addCookie(cookie);*/
        	map.put("msg", "success");
        	map.put("role", role);
        	map.put("returncode", 1);
        	map.put("username", username);
        	session.setAttribute("role", role);
        	session.setAttribute("userId", userId);
        	session.setAttribute("username", username);
        	session.setAttribute("sessionId", sessionId);
        	session.setAttribute("teaname", teaName);
        return map ;
    }
    
    @RequestMapping(value = "/judge", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> judgeIdentity (HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map = new HashMap<>();
    	Subject subject = SecurityUtils.getSubject();
    	Session session =  subject.getSession();
    	String role = (String) session.getAttribute("role");
    	map.put("role", role);
    	int userId = (int) session.getAttribute("userId");
    	map.put("userId", userId);
    	String	username = (String) session.getAttribute("username");
    	map.put("username", username);
    	String  teaName = (String) session.getAttribute("teaname");
    	map.put("teaname", teaName);
    	return map;
    }
    
	@RequestMapping(value = "/register/userAdd", method = RequestMethod.POST , consumes="application/json")
	@ResponseBody
	public Map<String,Object> addUser(@RequestBody User user ,HttpServletRequest request) {
		System.out.println(user.toString());
		int count = loginService.addUser(user);
		Map<String, Object> map = new HashMap<>();
		if(count > 0) {
			map.put("msg", 1);
			return map;
		}
		else {
			map.put("msg", 0);
			return map;
		}
	}
}
