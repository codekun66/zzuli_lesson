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
     * 查询所有课程信息列表
     *
     * @return
     */
	List<Map<String, Object>> queryLessons();
	/**
     * 查询有效的课程信息列表
     *
     * @return
     */
	List<Map<String, Object>> queryValidLessons();
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
	/**
	 * 根据教师编号查询课程信息
	 * @return Lesson
	 * 
	 */
	List<Map<String, Object>> queryLessonInfoByTeaId(@Param("teaId") int teaId);
	
	/**
	 * 查询课程总数totalCount
	 * @param 
	 * @return 
	 */
	int queryLessonsTotalCount();
	/**
	 * 查询课程总数totalCount
	 * @param 
	 * @return 
	 */
	int queryLessonsValidCount();
	
	/**
	 * 查询课程所有章
	 * @param 
	 * @return 
	 */
	List<Map<String, Object>> queryAllChapter(@Param("id") int id);
	
	/**
	 * 查询课程所有节
	 * @param 
	 * @return 
	 */
	List<Map<String, Object>> queryAllSection(@Param("id") int id);
	/**
     * 添加课程
     *
     */
	int insertLesson(Lessons lesson);
	/**
     * 根据关键字筛选课程课程
     *
     */
	List<Map<String, Object>> queryLessonsByKeyWord(Map<String, Object> map);
	/**
     * 根据节id返回课程地址
     *
     */
	Map<String, Object> queryVideoUrlBySectionId(@Param("id") int id);
	/**
     * 根据节id查询章id
     *
     */
	Map<String, Object> queryChapterIdBySectionId(@Param("id") int id);
	/**
     * 根据章id查询课程id
     *
     */
	Map<String, Object> queryLessonIdByChapterId(@Param("chapterId") int chapterId);
	/**
	 * 查询课程所有节Map
	 * @param 
	 * @return 
	 */
	List<Map<String, Object>> queryAllSectionMap(Map<String, Object> map);
}
