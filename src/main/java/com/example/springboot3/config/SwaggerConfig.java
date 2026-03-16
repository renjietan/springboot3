package com.example.springboot3.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("XX项目接口文档")          // 文档标题
                        .description("这是基于OpenAPI 3的接口文档") // 文档描述
                        .version("v1.0.0")                // 版本号
                        .contact(new Contact()            // 联系人
                                .name("开发者")
                                .email("trj3226529@qq.com")
                                .url("https://wx.mail.qq.com"))
                        .license(new License()            // 许可证
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}