package com.zzuli.lesson.service;

import java.util.List;

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
	List<Lessons> getLessonsList();
	
	
}
