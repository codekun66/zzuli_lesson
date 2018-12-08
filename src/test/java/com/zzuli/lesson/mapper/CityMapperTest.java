package com.zzuli.lesson.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzuli.lesson.bean.City;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTest {
	@Autowired  //Spring动态的CityMapper的Mybatis实现类注入
	private CityMapper cityMapper;
	@Test
	@Ignore
	public void testFindAllCity() {
		List<City> cityList = cityMapper.findAllCity();
		assertEquals(2, cityList.size());
	}

	@Test
	public void testFindById() {
		City city = cityMapper.findById((long) 2);
		assertEquals("郑州", city.getCityName());
	}

	@Test
	public void testSaveCity() {
		City city=new City();
		city.setCityName("北京");
		city.setProvinceId((long)3);
		city.setDescription("首都");
		city.setId((long)4);
	    Long effectednum =cityMapper.saveCity(city);
	    assertEquals(1, (long)effectednum);
	
	}

	@Test
	public void testUpdateCity() {
		City city=new City();
		city.setCityName("长沙");
		city.setId((long)4);
		Long effectednum =cityMapper.updateCity(city);
	    assertEquals(1, (long)effectednum);
	}

	@Test
	public void testDeleteCity() {
		cityMapper.deleteCity((long) 4);
	}

}
