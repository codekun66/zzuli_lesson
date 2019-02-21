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
	 * 获取所有课程列表
	 * 
	 * @return
	 */
	List<Map<String, Object>> getLessonsList() throws Exception;
	
	/**
	 * 获取有效的课程列表
	 * 
	 * @return
	 */
	List<Map<String, Object>> getValidLessonsList() throws Exception;

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
	/**
	 * 获得所有课程总数totalCount
	 *
	 * @return
	 */
	int getLessonsTotalCount();
	/**
	 * 获得有效课程总数validCount
	 *
	 * @return
	 */
	int getLessonsValidCount();
	/**
	 * 获得课程所有章
	 *
	 * @return
	 */
	List<Map<String, Object>> getAllChapter(int id);
	/**
	 * 添加课程
	 *
	 * @return
	 */
	int addLesson(Lessons lesson);
	/**
	 * 根据关键字筛选课程
	 *
	 * @return
	 */
	List<Map<String, Object>> getLessonsByKeyWord(Map<String, Object> map);
	/**
	 * 根据节id返回课程地址
	 *
	 * @return
	 */
	Map<String, Object> getVideoUrlBySectionId (int id);
}
