package com.zzuli.lesson.service;

import java.util.Map;

public interface LoginService {

	/**
	 * 获取密码
	 * 
	 * @return
	 */
	String getPassword(String username);
	
	/**
     * 获得角色权限
     * @param username 用户名
     * @return user/admin
     */
	String getRole(String username);
    /**
     * 获得用户id
     * @param username 用户名
     * @return user/admin
     */
    int getUserId(String username);
}
