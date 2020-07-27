package com.ying.sell.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;


/*
       开启Swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置了Swagger的Docket实例
    @Bean
    public Docket docket(){
            return new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo(){
        //Contact 联系人信息
        Contact contact = new Contact("Captain", "#", "无");
        return new ApiInfo("Sell相关Swagger文档", "Api Documentation", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }


}
