package com.zzuli.lesson.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzuli.lesson.bean.Lessons;
import com.zzuli.lesson.mapper.BackLessonsMapper;
import com.zzuli.lesson.mapper.LessonsMapper;
import com.zzuli.lesson.service.BackLessonsService;

@Service
public class BackLessonsServiceImpl implements BackLessonsService {

	@Autowired  
	private BackLessonsMapper backLessonsMapper ;	
	@Override
	public List<Map<String, Object>> getBackLessonsList() throws Exception {
		
		return backLessonsMapper.queryBackLessons();
	}
	@Override
	public int addLessons(Lessons lessons) {
		
		return  backLessonsMapper.insertLessons(lessons);
	}

}
