package com.zzuli.lesson.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzuli.lesson.bean.City;
import com.zzuli.lesson.service.CityService;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */

@Controller   
public class CityRestController {

    @Autowired
    private CityService cityService;
    //配置url映射
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("id") Long id , ModelMap map) {  //@PathVariable用于定义自定义或动态请求URI
    	map.put("name", cityService.findCityById(id).getCityName());
        return "index1";
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    @ResponseBody
    public List<City> findAllCity() {
        return cityService.getAllCity();
    }
    /*public Map<String, Object> findAllCity(){
    	Map<String, Object> modelmap = new HashMap<String, Object>();
    	List<City> list = new ArrayList<City>();
    	list = cityService.getAllCity();
    	modelmap.put("citykey", list);
    	return modelmap;
    }*/

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {  
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}