package com.zzuli.lesson.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzuli.lesson.bean.Lessons;
import com.zzuli.lesson.mapper.LessonsMapper;
import com.zzuli.lesson.service.LessonsService;
@Service
public class LessonsServiceImpl implements LessonsService {

	//使用mapper层提供的接口
	@Autowired  
	private LessonsMapper lessonsMapper;
	
	@Override
	public List<Lessons> getLessonsList() {
		
		return lessonsMapper.queryLessons();
	}

}
