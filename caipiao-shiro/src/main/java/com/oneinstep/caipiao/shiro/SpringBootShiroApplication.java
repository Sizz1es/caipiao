package com.oneinstep.caipiao.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oneinstep.caipiao.*.dao") //指定包扫描路径，扫描所有的mapper
public class SpringBootShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShiroApplication.class, args);
	}
}
