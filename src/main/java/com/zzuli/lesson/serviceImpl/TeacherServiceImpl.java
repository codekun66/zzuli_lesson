package com.zzuli.lesson.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.zzuli.lesson.bean.Teacher;
import com.zzuli.lesson.mapper.TeacherMapper;
import com.zzuli.lesson.service.TeacherServive;
import com.zzuli.lesson.util.ConstantUtil;
import com.zzuli.lesson.util.RedisUtil;

public class TeacherServiceImpl implements TeacherServive {

	//使用mapper层提供的接口
	@Autowired  
	private TeacherMapper teacherMapper;
	//注入了 RedisTemplate 对象
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	RedisUtil redisUtil;
	
	@Override
	public List<Map<String, Object>> getTeacherList() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = teacherMapper.queryTeacher();
		for (Map<String, Object> map : list) {
			String url = (String) map.get("picUrl");
			
			String ultimaUrl = ConstantUtil.FTP_PRE.FTP_PRE + url ;
			map.put("picUrl", ultimaUrl);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getValidTeacherList() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = teacherMapper.queryValidTeacher();
		for (Map<String, Object> map : list) {
			String url = (String) map.get("picUrl");
			
			String ultimaUrl = ConstantUtil.FTP_PRE.FTP_PRE + url ;
			map.put("picUrl", ultimaUrl);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getTeacherInfoByID(int id) {
		// TODO Auto-generated method stub
		return teacherMapper.queryTeacherById(id);
	}

	@Override
	public int getTeacherTotalCount() {
		// TODO Auto-generated method stub
		return teacherMapper.queryTeacherTotalCount();
	}

	@Override
	public int getTeacherValidCount() {
		// TODO Auto-generated method stub
		return teacherMapper.queryTeacherValidCount();
	}

	@Override
	public int addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
            return teacherMapper.insertTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
	}

}
