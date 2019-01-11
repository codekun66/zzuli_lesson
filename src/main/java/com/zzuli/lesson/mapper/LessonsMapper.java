package com.zzuli.lesson.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	 /**
     * 添加课程信息
     *
     * @return
     */
	int insertLessons(Lessons lessons);
	 /**
     * 根据pagegview获取热门课程信息
     * 
     * @return
     */
	List<Map<String, Object>> queryPageViewByPageView();   
	  /**
	  * 更新对应id浏览量
	  *
	  * @return
	  */
	int updatePageView(@Param("id") int id); 
	/**
	 * 根据Id查询课程信息
	 * @param teaId
	 * @return Teacher
	 */
	Map<String, Object> queryLessonsInfoById(@Param("id") int id);
	
}
