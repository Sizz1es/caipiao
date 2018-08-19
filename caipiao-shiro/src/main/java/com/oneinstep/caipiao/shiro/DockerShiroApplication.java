package com.oneinstep.caipiao.shiro;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.oneinstep.caipiao.*.dao") //指定包扫描路径，扫描所有的mapper
public class DockerShiroApplication {

	 //配置mybatis的分页插件pageHelper
	 @Bean
     public PageHelper pageHelper(){
			PageHelper pageHelper = new PageHelper();
			Properties properties = new Properties();
			properties.setProperty("offsetAsPageNum","true");
			properties.setProperty("rowBoundsWithCount","true");
			properties.setProperty("reasonable","true");
			properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
			pageHelper.setProperties(properties);
			return pageHelper;
     }


     //使用Docker容器，便于部署和启动项目
	 public static void main(String[] args) {
		SpringApplication.run(DockerShiroApplication.class, args);
	 }
}
