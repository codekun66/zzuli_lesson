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
	public List<Map<String, Object>> getValidLessonsList() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = lessonsMapper.queryValidLessons();
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
	    Map<String, Object> map = lessonsMapper.queryLessonsInfoById(id);
	    String url = (String) map.get("lessPicUrl");
	    String urlAdd = ConstantUtil.FTP_PRE.FTP_PRE + url ;
	    map.put("lessPicUrl", urlAdd);
		return map;
	}

	@Override
	public List<Map<String, Object>> getlessonInfoByTeaId(int teaId) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = lessonsMapper.queryLessonInfoByTeaId(teaId);
		for (Map<String, Object> map2 : list) {
			 String url = (String) map2.get("lessPicUrl");
			    String urlAdd = ConstantUtil.FTP_PRE.FTP_PRE + url ;
			    map2.put("lessPicUrl", urlAdd);
		}
		return list;
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

	

	@Override
	public int getLessonsValidCount() {
		// TODO Auto-generated method stub
		return lessonsMapper.queryLessonsValidCount();
	}

	@Override
	public int addLesson(Lessons lesson) {
		// TODO Auto-generated method stub
		try {
            return lessonsMapper.insertLesson(lesson);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
	}
	@Override
	public List<Map<String, Object>> getLessonsByKeyWord(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
	    String keyWord = (String) map.get("keyWord");
	    String easy = (String) map.get("easy");
	    String keyWord1 = null;
	    String easy1 = null ;
	    if(keyWord != null) {
		    if("bcyy".equals(keyWord)) {
		    	keyWord1 = "编程语言";
		    }else if ("hdkf".equals(keyWord)) {
		    	keyWord1 = "后端开发";
		    }else if ("qdkf".equals(keyWord)) {
		    	keyWord1 = "前端开发";
		    }else if ("ydkf".equals(keyWord)) {
		    	keyWord1 = "移动开发";
		    }else if ("wlyyw".equals(keyWord)) {
		    	keyWord1 = "网络与运维";
		    }
	    map.put("keyWord", "%" + keyWord1 + "%");
	    }
	    if(easy != null) {
	    	if("1".equals(easy)) {
	    		easy1 = "入门";
	    	}else if ("2".equals(easy)) {
	    		easy1 = "初级";
	    	}
	    	else if ("3".equals(easy)) {
	    		easy1 = "中级";
	    	}
	    	else if ("4".equals(easy)) {
	    		easy1 = "高级";
	    	}
	    	map.put("easy" , "%" + easy1 + "%");
	    }
	    
	    list = lessonsMapper.queryLessonsByKeyWord(map);
		for (Map<String, Object> map2 : list) {
			String url = (String) map2.get("lessPicUrl");
			String ultimaUrl = ConstantUtil.FTP_PRE.FTP_PRE + url ;
			map2.put("lessPicUrl", ultimaUrl);
		}
		return list;
	}
	
	@Override
	public Map<String, Object> getVideoUrlBySectionId(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map = lessonsMapper.queryVideoUrlBySectionId(id);
		String videoUrl = (String) map.get("resource_url");
		String videoUrlAdd = ConstantUtil.FTP_PRE.FTP_PRE + videoUrl ;
		map.put("resource_url", videoUrlAdd);
		return map;
	}
	
	@Override
	public Map<String, Object> getLessonIdBySectionId(int id) {
		Map<String, Object> map = lessonsMapper.queryChapterIdBySectionId(id);
		int chapterId = (int) map.get("chapter_id");
		Map<String, Object> map2 = lessonsMapper.queryLessonIdByChapterId(chapterId);
		return map2;
	}
	
	@Override
	public List<Map<String, Object>> getAllChapterMap(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		list = lessonsMapper.queryAllSectionMap(map);
		for (Map<String, Object> map2 : list) {
			int chapterId= (int) map2.get("id");
			list2 = lessonsMapper.queryAllSection(chapterId);
			map2.put("section", list2);
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
