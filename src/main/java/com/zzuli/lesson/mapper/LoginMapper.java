package com.zzuli.lesson.mapper;

import java.util.Map;

import com.zzuli.lesson.bean.Lessons;
import com.zzuli.lesson.bean.User;

public interface LoginMapper {

	/**
     * 获得密码
     * @param username 用户名
     */
    String queryPasswordByUsername(String username);

    /**
     * 获得角色权限
     * @param username 用户名
     * @return user/admin
     */
    String queryRoleByUsername(String username);
    
    /**
     * 获得用户id
     * @param username 用户名
     * @return user/admin
     */
    int queryUserId(String username);
    /**
     * 获得用户姓名
     * @param username 用户名
     * @return teaname
     */
    String queryTeaNameByUsername(String username);
	/**
	 * 添加user信息
	 *
	 * @return
	 */
	int insertUser(User user);
}
