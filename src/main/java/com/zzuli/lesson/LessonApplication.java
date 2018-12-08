package com.zzuli.lesson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication //Spring Boot 应用的标识
// mapper 接口类扫描包配置
@MapperScan("com.zzuli.lesson.mapper")
public class LessonApplication {
	public static void main(String[] args) {
		SpringApplication.run(LessonApplication.class, args);
}
}
