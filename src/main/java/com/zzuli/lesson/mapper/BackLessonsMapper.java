package com.zzuli.lesson.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zzuli.lesson.bean.Lessons;

public interface BackLessonsMapper {

	/**
	 * 查询后台admin课程信息列表
	 *
	 * @return
	 */
	List<Map<String, Object>> queryBackLessons();

	/**
	 * 查询后台teacher课程信息列表
	 *
	 * @return
	 */
	List<Map<String, Object>> queryBackLessonsTeacher(int userId);

	/**
	 * 添加课程信息
	 *
	 * @return
	 */
	int insertLessons(Lessons lessons);

	/**
	 * 删除课程信息
	 *
	 * @return
	 */
	int deleteLessons(@Param("id") int id);
}
