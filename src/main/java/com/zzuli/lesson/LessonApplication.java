package com.zzuli.lesson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication //Spring Boot 应用的标识
@MapperScan("com.zzuli.lesson.mapper")  // mapper 接口类扫描包配置
@EnableCaching  //开启springboot对缓存的支持
public class LessonApplication {
	public static void main(String[] args) {
		SpringApplication.run(LessonApplication.class, args);
}
}
