package com.zzuli.lesson.mapper;

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
}
