package com.zzuli.lesson.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzuli.lesson.service.JedisService;
import com.zzuli.lesson.service.LessonsService;
import com.zzuli.lesson.util.RedisUtil;

@Service
public class JedisServiceImpl implements JedisService {
	
	@Autowired LessonsService lessonsService;
	@Autowired RedisUtil redisUtil;
	
	public void saveNewsClickNum(String id) throws Exception {
		redisUtil.incr(id);
		int idInt = Integer.parseInt(id);
		//更新数据库访问量
		lessonsService.updatePageView(idInt);
	/*	String num = redisUtil.getString(id);
		if(num == null)
		System.out.println(num);
		int numx =Integer.parseInt(num)+1;
		redisUtil.setString(id, String.valueOf(numx));
		jedis.set(id , String.valueOf(numx));
		if(jedis.exists("lessons"+id)) {
			
		}else {
			//从数据库中取
		}*/
	}
}
