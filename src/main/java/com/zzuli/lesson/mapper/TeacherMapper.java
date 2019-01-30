package com.zzuli.lesson.mapper;

import java.util.List;
import java.util.Map;

import com.zzuli.lesson.bean.Teacher;

/**
 * Teacher Mapper接口类
 * @author Jqf
 * @data 2019/1/30
 * 
 */
public interface TeacherMapper {
	/**
     * 查询所有教师信息列表
     *
     * @return
     */
	List<Map<String, Object>> queryTeacher();
	/**
     * 查询有效教师信息列表
     *
     * @return
     */
	List<Map<String, Object>> queryValidTeacher();
	/**
    *  根据教师ID获取教师信息列表
    *
    * @return
    */
	List<Map<String, Object>> queryTeacherById();
	/**
    * 获取教师信息列表所有的信息数量
    *
    * @return
    */
	Integer queryTeacherTotalCount();
	/**
	* 获取教师信息列表有效的信息数量
	*
	* @return
	*/
	Integer queryTeacherValidCount();
	/**
	* 添加教师信息
	*
	*/
	int insertTeacher(Teacher teacher);
	
}
