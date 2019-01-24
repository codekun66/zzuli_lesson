package com.zzuli.lesson.service;
/**
 * jedis接口类
 *
 * Created by 
 */
public interface JedisService {
	/**
	 * 保存对应id的点击量
	 * 
	 * @return
	 */
	void saveNewsClickNum(String id) throws Exception;
	
}
