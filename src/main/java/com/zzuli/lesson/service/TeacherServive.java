package com.zzuli.lesson.service;

import java.util.List;
import java.util.Map;

import com.zzuli.lesson.bean.Teacher;

/**
 * 教师业务接口类
 *
 * Created by Jqf
 * date 2019/1/31
 */
public interface TeacherServive {

	/**
	 * 获取所有教师列表
	 * 
	 * @return
	 */
	List<Map<String,Object>> getTeacherList() throws Exception;
	/**
	 * 获取有效的教师列表
	 * 
	 * @return
	 */
	List<Map<String,Object>> getValidTeacherList() throws Exception;
	/**
	 * 根据教师ID获取教师信息
	 * 
	 * @return
	 */
	List<Map<String,Object>> getTeacherInfoByID(int id);
	/**
	 * 获得所有教师总数totalCount
	 *
	 * @return
	 */
	int getTeacherTotalCount();
	/**
	 * 获得有效教师总数validCount
	 *
	 * @return
	 */
	int getTeacherValidCount();
	/**
	* 添加教师信息
	* @return
	*/
	int addTeacher(Teacher teacher);
	
}
