package com.oneinstep.caipiao.shiro.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 * @author henry.shaw(xiaoyao)
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "caipiao", name = "swagger-open", havingValue = "true")
public class SwaggerConfig {

    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                         //这里采用包含注解的方式来确定要显示的接口
                //.apis(RequestHandlerSelectors.basePackage("com.oneinstep.caipiao.shiro.controller"))    //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("CaiPiao Doc")
                //描述
                .description("CaiPiao Api文档")
                .termsOfServiceUrl("https://github.com/oneinstep/caipiao")
                //创建人
                .contact(new Contact("henry.shaw(xiaoyao)","https://github.com/oneinstep/caipiao","oneinstep@163.com"))
                //版本号
                .version("1.0")
                .build();
    }

}
