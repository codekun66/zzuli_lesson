package com.zzuli.lesson.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzuli.lesson.bean.Teacher;

/**
 * 教师Mapper接口类
 */
public interface TeacherMapper {
	/**
	 * 查询教师列表
	 * 
	 * @return TeacherList
	 */
	List<Teacher> queryTeacher();

	/**
	 * 根据Id查询教师
	 * @param teaId
	 * @return Teacher
	 */
	Teacher queryTeacherById(@Param("teaId") int teaId);

	/**
	 * 插入教师信息
	 * 
	 * @param teacher
	 * @return
	 */
	int insertTeacher(Teacher teacher);

	/**
	 * 更新教师信息
	 * 
	 * @param teacher
	 * @return
	 */
	int updateTeacher(Teacher teacher);

	/**
	 * 删除教师信息
	 * 
	 * @param teaId
	 * @return
	 */
	int deleteTeacher(int teaId);
}
