package com.lwl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("李文龙")
                .enable(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lwl.controller"))
                //.paths(PathSelectors.ant("/lwl/controller/**"))
                .build();
    }

    private ApiInfo apiInfo() {

        Contact contact = new Contact("李文龙", "", "2087131324@qq.com");
        return new ApiInfo(
                "graduation design test interface Documentation",
                "graduation design",
                "v1.0",
                "",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
