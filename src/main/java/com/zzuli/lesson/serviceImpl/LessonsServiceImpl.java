package com.zzuli.lesson.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import com.zzuli.lesson.bean.Lessons;
import com.zzuli.lesson.mapper.LessonsMapper;
import com.zzuli.lesson.service.LessonsService;
import com.zzuli.lesson.util.ConstantUtil;
import com.zzuli.lesson.util.RedisUtil;
@Service  //声明当前是Spring管理的一个Bean
public class LessonsServiceImpl implements LessonsService {

	//使用mapper层提供的接口
	@Autowired  
	private LessonsMapper lessonsMapper;
	//注入了 RedisTemplate 对象
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	RedisUtil redisUtil;
	@Override
	public List<Map<String, Object>> getLessonsList() throws Exception {
		//从redis拿到访问量放list中
   		/*List<Lessons> listLessons = lessonsMapper.queryLessons();
		for (Iterator iterator = listLessons.iterator(); iterator.hasNext();) {
			Lessons object = (Lessons) iterator.next();
			object.setPageView(redisUtil.getString(String.valueOf(object.getId())));
		}
		*/
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = lessonsMapper.queryLessons();
		for (Map<String, Object> map : list) {
			String url = (String) map.get("lessPicUrl");
			
			String ultimaUrl = ConstantUtil.FTP_PRE.FTP_PRE + url ;
			map.put("lessPicUrl", ultimaUrl);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getPageView() {
	
		return lessonsMapper.queryPageViewByPageView();
	}

	@Override
	public int updatePageView(int id) {
		
		return lessonsMapper.updatePageView(id);
	}
	

	@Override
	public Map<String, Object> getlessonsInfoById(int id) {
	
		return lessonsMapper.queryLessonsInfoById(id);
	}

	@Override
	public int getLessonsTotalCount() {
		
		return lessonsMapper.queryLessonsTotalCount();
	}

	@Override
	public List<Map<String, Object>> getAllChapter(int id) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		list = lessonsMapper.queryAllChapter(id);
		for (Map<String, Object> map : list) {
			int chapterId= (int) map.get("id");
			list2 = lessonsMapper.queryAllSection(chapterId);
			map.put("section", list2);
		}
		return list;
	}
	
	
	
	
	
/*	@Override
	@Cacheable(value="getLessons",key="'lessons.getLessonsList2'") //表示当前方法使用缓存 ，并存入redis数据库中
			   //value属性：表示存入redis数据库的key
				//key属性：用于指定方法执行返回值的key，该属性是spring用的，不写也有默认值
				//key="'fdflj'"
	public List<Lessons> getLessonsList2() {
		return lessonsMapper.queryLessons();
	}*/
}
