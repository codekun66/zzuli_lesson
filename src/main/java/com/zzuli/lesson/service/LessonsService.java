package com.zzuli.lesson.service;

import java.util.List;
import java.util.Map;

import com.zzuli.lesson.bean.Lessons;

/**
 * 课程业务接口类
 *
 * Created by
 */
public interface LessonsService {
	/**
	 * 获取课程列表
	 * 
	 * @return
	 */
	List<Lessons> getLessonsList() throws Exception;

	/**
	 * 新增课程信息
	 *
	 * @param Lessons
	 * @return
	 */
	int addLessons(Lessons lessons);

	/**
	 * 热门课程排行
	 *
	 * @param Lessons
	 * @return
	 */
	List<Map<String, Object>> getPageView();

	/**
	 * 更新对应id浏览量
	 *
	 * @return
	 */
	int updatePageView(int id);
	/**
	 * 通过Id获取课程信息
	 * 
	 * @param teacher
	 * @return
	 */
	Map<String, Object> getlessonsInfoById(int id);
	
	
	List<Lessons> getLessonsList2();
}
