package com.zzuli.lesson.service;

import java.util.List;
import java.util.Map;

import com.zzuli.lesson.bean.Lessons;

public interface BackLessonsService {

	/**
	 * 获取后台信息列表
	 * 
	 * @return
	 */
	List<Map<String, Object>> getBackLessonsList() throws Exception;
	
	/**
	 * 新增课程信息
	 *
	 * @param Lessons
	 * @return
	 */
	int addLessons(Lessons lessons);
}
