package com.lb.bean.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author : lb
 * @date : 2020/9/1 11:00
 * @description :
 */
@Configuration
public class SwaggerConfig {

   /* @Bean
    Docket apiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("注解bean接口文档")
                .description("注解bean接口文档")
                .version("1.1")
                .build();
    }*/
}
