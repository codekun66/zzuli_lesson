package com.zzuli.lesson.mapper;

import java.util.List;

import com.zzuli.lesson.bean.Lessons;

/**
 * lessons  Mapper接口类
 * 
 */
public interface LessonsMapper {
    /**
     * 获取课程信息列表
     *
     * @return
     */
	List<Lessons> queryLessons();   
	
}
