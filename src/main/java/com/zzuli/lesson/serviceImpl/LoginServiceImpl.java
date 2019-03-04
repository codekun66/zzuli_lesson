package com.zzuli.lesson.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzuli.lesson.mapper.LoginMapper;
import com.zzuli.lesson.service.LoginService;
@Service
public class LoginServiceImpl  implements LoginService{

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public String getPassword(String username) {
		// TODO Auto-generated method stub
		return loginMapper.queryPasswordByUsername(username);
	}

	@Override
	public String getRole(String username) {
		// TODO Auto-generated method stub
		return loginMapper.queryRoleByUsername(username);
	}

	@Override
	public int getUserId(String username) {
		// TODO Auto-generated method stub
		return loginMapper.queryUserId(username);
	}

	@Override
	public String getTeaName(String username) {
		// TODO Auto-generated method stub
		return loginMapper.queryTeaNameByUsername(username);
	}
	

}
