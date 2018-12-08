package com.zzuli.lesson.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzuli.lesson.bean.City;
import com.zzuli.lesson.mapper.CityMapper;
import com.zzuli.lesson.mapper.CityMapperTest;
import com.zzuli.lesson.service.*;

@Service
public class CityServiceImpl implements CityService {
	//使用mapper层提供的接口
	@Autowired  
	private CityMapper cityMapper;

    public List<City> getAllCity(){
        return cityMapper.findAllCity();//返回所有的信息 
    }

    public City findCityById(Long id) {
        return cityMapper.findById(id);
    }
    @Transactional //事务控制 默认异常处理RuntimeException
    @Override
    public Long saveCity(City city) {
    	if(city.getCityName() != null && !"".equals(city.getCityName())) {
    		
    	}
        return cityMapper.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        return cityMapper.updateCity(city);
    }

    @Override
    public Long deleteCity(Long id) {
        return cityMapper.deleteCity(id);
    }

}
