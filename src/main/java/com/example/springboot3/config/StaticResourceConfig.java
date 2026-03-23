package com.example.springboot3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将 /uploads/** 映射到上传目录（注意 file: 前缀）
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadPath + "/");

        // 如果还需要保留默认静态资源映射，可以保留默认配置，无需额外添加
        // Spring Boot 会自动处理 classpath:/static/ 等
    }
}