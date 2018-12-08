package com.zzuli.lesson.service;

import java.util.List;

import com.zzuli.lesson.bean.Teacher;

/**
 * 教师业务逻辑接口类
 *
 */
public interface TeacherService {
	/**
	 * 获取教师列表
	 * 
	 * @return
	 */
	List<Teacher> getTeacherList();

	/**
	 * 通过Id获取教师信息
	 * 
	 * @param teacher
	 * @return
	 */
	Teacher getTeacherById(int teaId);

	/**
	 * 增加教师信息
	 * 
	 * @param teacher
	 * @return
	 */
	boolean addTeacher(Teacher teacher);

	/**
	 * 修改教师信息
	 * 
	 * @param teacher
	 * @return
	 */
	boolean modifyTeacher(Teacher teacher);

	/**
	 * 删除教师息
	 * 
	 * @param teacher
	 * @return
	 */
	boolean deleteTeacher(int teaId);

}

